package hei.grade.school.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

// Lombok
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
// JPA : pour faire en sorte que çà devienne une table.
@Entity
@Table(name = "\"Semester\"")
public class Semester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;

    private String startTime;

    private String endTime;

    private boolean status;

}
