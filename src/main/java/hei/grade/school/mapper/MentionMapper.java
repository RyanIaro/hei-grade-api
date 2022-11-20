package hei.grade.school.mapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MentionMapper {
    private String name;
    private Float startNote;
    private Float endNote;
}
