package hei.grade.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hei.grade.school.model.Course;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

}
