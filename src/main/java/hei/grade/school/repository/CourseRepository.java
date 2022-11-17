package hei.grade.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hei.grade.school.model.Course;

public interface CourseRepository extends JpaRepository<Course, String> {

}
