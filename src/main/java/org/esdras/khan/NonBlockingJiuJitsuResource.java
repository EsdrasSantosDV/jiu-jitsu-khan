package org.esdras.khan;

import io.smallrye.common.annotation.NonBlocking;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.esdras.khan.entity.ClassEntity;
import org.esdras.khan.entity.Classroom;
import org.esdras.khan.entity.Presence;
import org.esdras.khan.entity.StudentEntity;
import org.esdras.khan.response.ClassDetailResponse;
import org.esdras.khan.response.ClassRoomDetailResponse;

import java.util.List;
import java.util.stream.Collectors;

@Path("/jiu-jitsu/nao-bloqueante")
@Produces(MediaType.APPLICATION_JSON)
@NonBlocking
public class NonBlockingJiuJitsuResource {

    @GET
    @Path("/{classId}")
    public Uni<Response> getClassDetails(@PathParam("classId") Long classId) {
        System.out.println("Thread (getClassDetails): " + Thread.currentThread().getName());  // Log da thread

        return ClassEntity.<ClassEntity>findById(classId)
                .onItem().transformToUni(classEntity -> {
                    System.out.println("Thread (findById): " + Thread.currentThread().getName());  // Log da thread
                    if (classEntity == null) {
                        return Uni.createFrom().item(Response.status(Response.Status.NOT_FOUND)
                                .entity("Aula não encontrada")
                                .build());
                    }

                    return Classroom.<Classroom>list("jiuJitsuClass.id", classId)
                            .onItem().transformToUni(classrooms -> {
                                System.out.println("Thread (list classrooms): " + Thread.currentThread().getName());  // Log da thread

                                List<Uni<ClassRoomDetailResponse>> classroomDetailsUnis = classrooms.stream()
                                        .map(this::getClassroomDetails)
                                        .collect(Collectors.toList());

                                return Uni.combine().all().unis(classroomDetailsUnis).usingConcurrencyOf(1).with(responses -> {
                                    System.out.println("Thread (combine unis): " + Thread.currentThread().getName());  // Log da thread

                                    List<ClassRoomDetailResponse> classroomDetails = responses.stream()
                                            .map(response -> (ClassRoomDetailResponse) response)
                                            .collect(Collectors.toList());

                                    return Response.ok(new ClassDetailResponse(
                                            classEntity.className,
                                            classEntity.instructor,
                                            classroomDetails)).build();
                                });
                            });
                });
    }


    private Uni<ClassRoomDetailResponse> getClassroomDetails(Classroom classroom) {
        System.out.println("Thread: " + Thread.currentThread().getName() + " - Buscando presenças para a sessão: " + classroom.startTime);

        return Presence.<Presence>list("classroom.id", classroom.id)
                .onItem().transform(presences -> {

                    List<StudentEntity> presentStudents = presences.stream()
                            .filter(presence -> Boolean.TRUE.equals(presence.confirmed))
                            .map(presence -> presence.student)
                            .toList();

                    return new ClassRoomDetailResponse(
                            classroom.startTime.toString(),
                            presences.size(),
                            presentStudents.stream().map(student -> student.name).collect(Collectors.toList()));
                });
    }


}
