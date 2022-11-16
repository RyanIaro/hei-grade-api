package hei.grade.school.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table
public class Grade {
    @Id
    @Column(name = "id", nullable = false)
    private String id = UUID.randomUUID().toString();
    private Float mark;

    @ManyToOne
    private Users users_id;

    @ManyToOne
    private Evaluation evaluation_id;
}
