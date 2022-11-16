package hei.grade.school.model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class Users {
    @Id
    @Column(name = "id", nullable = false)
    private String id = UUID.randomUUID().toString();

    private String first_name;
    private String last_name;
    private Character sex;
    private LocalDate birth_date;
    private String address;
    private String phone;
    private String email;
    private LocalDate entrance_datetime;
    private String status;

    @ManyToOne
    private Group group_id;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Grade> grade;

}