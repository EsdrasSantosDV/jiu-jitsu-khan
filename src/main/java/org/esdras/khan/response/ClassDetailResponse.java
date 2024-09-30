package org.esdras.khan.response;

import java.util.List;

public record ClassDetailResponse(
        String className,
        String instructor,
        List<ClassRoomDetailResponse> classrooms
) {
}

