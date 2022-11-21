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
public class Groupe {
    @Id
    @Column(name = "id", nullable = false)
    private String id = UUID.randomUUID().toString();

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String level;
    private LocalDate startDate = LocalDate.now();
    private LocalDate endDate = null;
    private Boolean status = true;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Users> users;

    public Groupe(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public Groupe(String name, String level, LocalDate startDate, LocalDate endDate, Boolean status) {
        this.name = name;
        this.level = level;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

}
