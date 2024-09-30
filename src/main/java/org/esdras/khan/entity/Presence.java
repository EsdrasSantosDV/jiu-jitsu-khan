package org.esdras.khan.entity;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "presence")
public class Presence extends PanacheEntity {


    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)  // Foreign key para student_entity
    public StudentEntity student;

    @ManyToOne
    @JoinColumn(name = "classroom_id", nullable = false)  // Foreign key para classroom_entity
    public Classroom classroom;

    @Column(name = "confirmed", nullable = false)
    public Boolean confirmed;


    public Presence() {
    }


    public Presence(StudentEntity student, Classroom classroom, Boolean confirmed) {
        this.student = student;
        this.classroom = classroom;
        this.confirmed = confirmed;
    }
}
