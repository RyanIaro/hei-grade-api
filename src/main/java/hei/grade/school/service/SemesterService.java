package hei.grade.school.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import hei.grade.school.mapper.SemesterMapper;
import hei.grade.school.model.Semester;
import hei.grade.school.repository.SemesterRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SemesterService {

    private SemesterRepository semesterRepository;

    public List<Semester> findAllSemester() {
        return semesterRepository.findAll();
    }

    public Semester addSemester(SemesterMapper semesterMapper) {
        Semester semester = new Semester();
        semester.setName(semesterMapper.getName());
        semester.setStartDate(semesterMapper.getStartDate());
        semester.setEndDate(semesterMapper.getEndDate());
        semester.setStatus(semesterMapper.isStatus());

        semesterRepository.save(semester);

        return semesterRepository.findById(semester.getId()).get();
    }

    public Semester findSemesterById(String id) {
        return semesterRepository.findById(id).get();
    }

    @Transactional
    public Semester updateSemesterById(String id, SemesterMapper semesterMapper) {

        Semester semester = semesterRepository.findById(id).get();
        semester.setName(semesterMapper.getName());
        semester.setStartDate(semesterMapper.getStartDate());
        semester.setEndDate(semesterMapper.getEndDate());
        semester.setStatus(semesterMapper.isStatus());

        semesterRepository.save(semester);

        return semesterRepository.findById(semester.getId()).get();
    }

    public String deleteSemesterById(String id) {

        semesterRepository.deleteById(id);
        return "Evaluation deleted With Success";
    }

}
