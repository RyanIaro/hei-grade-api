package hei.grade.school.service;


import hei.grade.school.mapper.SemesterMapper;
import hei.grade.school.model.Semester;
import hei.grade.school.repository.SemesterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SemesterService {

    private SemesterRepository semesterRepository;

    public List<Semester> findAllSemester() {
        return semesterRepository.findAll();
    }

    private Semester addSemester(SemesterMapper semesterMapper){
        Semester semester = new Semester();
        semester.setName(semesterMapper.getName());
        semester.setStartTime(semesterMapper.getStartTime());
        semester.setEndTime(semesterMapper.getEndTime());
        semester.setStatus(semesterMapper.isStatus());

        semesterRepository.save(semester);

        return semesterRepository.findById(Long.valueOf(semester.getId())).get();
    }

    private Semester findSemesterById(String id){
        return semesterRepository.findById(Long.valueOf(id)).get();
    }

    private Semester updateSemesterById(String id, SemesterMapper semesterMapper){

        Semester semester = semesterRepository.findById(Long.valueOf(id)).get();
        semester.setName(semesterMapper.getName());
        semester.setStartTime(semesterMapper.getStartTime());
        semester.setEndTime(semesterMapper.getEndTime());
        semester.setStatus(semesterMapper.isStatus());

        semesterRepository.save(semester);

        return semesterRepository.findById(Long.valueOf(semester.getId())).get();
    }

    private void deleteSemesterById(String id){
         semesterRepository.deleteById(Long.valueOf(id));
    }



}
