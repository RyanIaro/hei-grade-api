package hei.grade.school.controller;

import hei.grade.school.mapper.EvaluationMapper;
import hei.grade.school.model.Evaluation;
import hei.grade.school.service.EvaluationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EvaluationController {

    private EvaluationService evaluationService;

    @GetMapping("/evaluations")
    public List<Evaluation> getAllEvaluations(){ return evaluationService.getAllEvaluation(); }

    @GetMapping("/evaluation/{id}")
    public Evaluation getEvaluationById(@PathVariable String id){
        return evaluationService.getEvaluationById(id);
    }

    @PostMapping("/evaluation")
    public Evaluation createEvaluation(@RequestBody EvaluationMapper evaluationMapper){
        return evaluationService.createEvaluation(evaluationMapper);
    }

    @PutMapping("evaluation/{evaluation_id}")
    public Evaluation updateEvaluation(
            @PathVariable String evaluation_id,
            @RequestBody EvaluationMapper evaluationMapper
                                       ){
        return evaluationService.updateEvaluation(evaluation_id, evaluationMapper);
    }

    @DeleteMapping("/evaluation/{id_evalutation}")
    public String deleteEvaluation(@PathVariable String id_evaluation){
        return evaluationService.deleteEvaluationById(id_evaluation);
    }
}
