package hei.grade.school.mapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SemesterMapper {
    private String name;

    private String startTime;

    private String endTime;

    private boolean status;
}
