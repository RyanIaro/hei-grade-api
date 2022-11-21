package hei.grade.school.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hei.grade.school.model.Course;
import hei.grade.school.service.CourseService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @PostMapping // Create course
    public Course createCourse(
            @RequestBody() Course course) throws ResponseStatusException {
        return courseService.createCourse(course);
    }

    @GetMapping // Get all course
    public List<Course> getAllCourse() throws ResponseStatusException {
        return courseService.getAllCourse();
    }

    @GetMapping("/{id}") // Get course by id
    public Course getCourseById(
            @PathVariable("id") String id) throws ResponseStatusException {
        return courseService.getCourseById(id);
    }

    @PutMapping("/{id}") // Update course by id
    public Course updateCourseById(
            @PathVariable("id") String id,
            @RequestBody() Course course) throws ResponseStatusException {
        return courseService.updateCourseById(id, course);
    }

    @DeleteMapping("/{id}") // Delete course by id
    public String deleteCourseById(
            @PathVariable("id") String id) throws ResponseStatusException {
        return courseService.deleteCourseById(id);
    }
}
