package hei.grade.school.model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// Lombok
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
// JPA : pour faire en sorte que çà devienne une table.
@Entity
@Table(name = "\"Semester\"")
public class Semester {
    @Id
    @Column(name = "id", nullable = false)
    private String id = UUID.randomUUID().toString();

    private String name;

    @JsonFormat(pattern ="yyyy-MM-dd")
    private LocalDate startDate;

    @JsonFormat(pattern ="yyyy-MM-dd")
    private LocalDate endDate;

    private Boolean status;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Evaluation> evaluation;
}