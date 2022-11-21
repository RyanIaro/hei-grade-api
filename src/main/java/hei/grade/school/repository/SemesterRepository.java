package hei.grade.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hei.grade.school.model.Semester;

@Repository
public interface SemesterRepository extends JpaRepository<Semester, String> {

}
