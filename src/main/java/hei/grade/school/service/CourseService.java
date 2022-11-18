package hei.grade.school.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import hei.grade.school.model.Course;
import hei.grade.school.repository.CourseRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CourseService {

    public final CourseRepository courseRepository;

    // Create Course
    public Course createCourse(Course course) {
        Course newCourse = new Course();
        try {
            newCourse.setName(course.getName());
            courseRepository.save(newCourse);
        } catch (ResponseStatusException e) {
            new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Serveur Error: Unable to create Course");
        }

        return courseRepository.findById(newCourse.getId()).get();
    }

    // Get All Course
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    // Get course by id
    public Course getCourseById(String id) {
        boolean courseExist = courseRepository.existsById(id);
        if (!courseExist) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Error: Course with id %s not found in database ", id));
        }

        return courseRepository.findById(id).get();
    }

    @Transactional // Update course by id
    public Course updateCourseById(String id, Course course) {

        boolean courseExist = courseRepository.existsById(id);
        if (!courseExist) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Error: Course with id %s not found in database ", id));
        }

        Course updateCourse = courseRepository.findById(id).get();

        try {
            if (course.getName() != null && course.getName().length() > 0
                    && !updateCourse.getName().equals(course.getName())) {
                updateCourse.setName(course.getName());
            }
        } catch (ResponseStatusException e) {
            new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Serveur Error: Unable to Update Course");
        }
        return updateCourse;
    }

    public String deleteCourseById(String id) {
        boolean courseExist = courseRepository.existsById(id);
        if (!courseExist) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Error: Course with id %s not found in database ", id));
        }
        courseRepository.deleteById(id);
        return "Course deleted With Success";
    }

}