package hei.grade.school.controller;

import hei.grade.school.mapper.GradeMapper;
import hei.grade.school.model.Grade;
import hei.grade.school.service.GradeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class GradeController {

    private GradeService gradeService;

    @GetMapping("/grades")
    public List<Grade> getAllGrades(){ return gradeService.getAllGrades(); }

    @GetMapping("/grade/{grade_id}")
    public Grade getGradeById(@PathVariable String grade_id){ return gradeService.getGradeBYId(grade_id); }

    @PostMapping("/grade")
    public Grade createGrade(@RequestBody GradeMapper gradeMapper){ return gradeService.createGrade(gradeMapper); }

    @PutMapping("/grade/{grade_id}")
    public Grade updateGrade(
            @PathVariable String grade_id,
            @RequestBody GradeMapper gradeMapper
    ){ return gradeService.updateGrade(grade_id, gradeMapper); }

    @DeleteMapping("/grade/{id_grade}")
    public String deleteGrade(@PathVariable String id_grade){ return gradeService.deleteGradeById(id_grade); }

}
