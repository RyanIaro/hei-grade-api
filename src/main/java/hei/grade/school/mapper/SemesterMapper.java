package hei.grade.school.mapper;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SemesterMapper {
    private String name;

    private LocalDate startDate;

    private LocalDate endDate;

    private boolean status;
}
