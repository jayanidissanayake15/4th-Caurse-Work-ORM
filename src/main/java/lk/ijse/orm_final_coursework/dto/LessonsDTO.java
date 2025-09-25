package lk.ijse.orm_final_coursework.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class LessonsDTO {
    private String lessonId;
    private String lessonDate;
    private String startTime;
    private String endTime;
    private String status;
    private String studentId;
    private String courseId;
    private String instructorId;

}
