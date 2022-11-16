package hei.grade.school.controller;

import hei.grade.school.mapper.SemesterMapper;
import hei.grade.school.model.Semester;
import hei.grade.school.service.SemesterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class SemesterController {

    public SemesterService semesterService;

    @GetMapping("/semesters")
    public List<Semester> getAllSemester(){
        return semesterService.findAllSemester();
    }

    @GetMapping("/semester/{id}")
    public Semester getSemesterById(@PathVariable String id_semester){
        return semesterService.findSemesterById(id_semester);
    }

    @PostMapping("semester")
    public Semester createSemester(
            @RequestBody SemesterMapper semesterMapper
    ){
        return semesterService.addSemester(semesterMapper);
    }

    @PutMapping("semester/semester_id")
    public Semester updateSemester(
            @PathVariable String id_semester,
            @RequestBody SemesterMapper semesterMapper
    ){
        return semesterService.updateSemesterById(id_semester, semesterMapper);
    }

    @DeleteMapping("/semester/{id_semester}")
    public void deleteSemesterById(@PathVariable String id_semester){
         semesterService.deleteSemesterById(id_semester);
    }

}
