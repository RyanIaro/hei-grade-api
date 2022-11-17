package hei.grade.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hei.grade.school.model.Groupe;

@Repository
public interface GroupeRepository extends JpaRepository<Groupe, String> {

}
