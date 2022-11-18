package hei.grade.school.repository;

import hei.grade.school.model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvalutionRepository extends JpaRepository<Evaluation, String> {
}
