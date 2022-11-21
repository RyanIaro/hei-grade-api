package hei.grade.school.mapper;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SemesterMapper {
    private String name;

    @JsonFormat(pattern ="yyyy-MM-dd")
    private LocalDate startDate;

    @JsonFormat(pattern ="yyyy-MM-dd")
    private LocalDate endDate;

    private boolean status;
}
