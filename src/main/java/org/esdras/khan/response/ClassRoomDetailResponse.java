package org.esdras.khan.response;

import java.util.List;

public record ClassRoomDetailResponse(
        String startTime,
        int totalPresences,
        List<String> presentStudents
) {
}
