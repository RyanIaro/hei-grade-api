package hei.grade.school.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import hei.grade.school.model.Groupe;
import hei.grade.school.repository.GroupeRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GroupeService {

    public final GroupeRepository groupeRepository;

    // Create groupe
    public Groupe createGroupe(Groupe groupe) {
        Groupe newGroupe = new Groupe();
        try {
            newGroupe.setName(groupe.getName());
            newGroupe.setLevel(groupe.getLevel());

            if (groupe.getStartDate() != null) {
                newGroupe.setStartDate(groupe.getStartDate());
            }

            if (groupe.getEndDate() != null) {
                newGroupe.setEndDate(groupe.getEndDate());
            }

            if (groupe.getStatus() != null) {
                newGroupe.setStatus(groupe.getStatus());
            }

            groupeRepository.save(newGroupe);
        } catch (ResponseStatusException e) {
            new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Serveur Error: Unable to create Groupe");
        }

        return groupeRepository.findById(newGroupe.getId()).get();
    }

    // Get All Groupe
    public List<Groupe> getAllGroupe() {
        return groupeRepository.findAll();
    }

    // Get Groupe by id
    public Groupe getGroupeById(String id) {
        boolean groupeExist = groupeRepository.existsById(id);
        if (!groupeExist) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Error: Groupe with id %s not found in database ", id));
        }

        return groupeRepository.findById(id).get();
    }

    @Transactional // Update Groupe by id
    public Groupe updateGroupeById(String id, Groupe groupe) {

        boolean groupeExist = groupeRepository.existsById(id);
        if (!groupeExist) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Error: Groupe with id %s not found in database ", id));
        }

        Groupe updateGroupe = groupeRepository.findById(id).get();

        try {
            if (groupe.getName() != null && groupe.getName().length() > 0
                    && !updateGroupe.getName().equals(groupe.getName())) {
                updateGroupe.setName(groupe.getName());
            }

            if (groupe.getLevel() != null && groupe.getLevel().length() > 0
                    && !updateGroupe.getLevel().equals(groupe.getLevel())) {
                updateGroupe.setLevel(groupe.getLevel());
            }

            if (groupe.getStartDate() != null && !updateGroupe.getStartDate().equals(groupe.getStartDate())) {
                updateGroupe.setStartDate(groupe.getStartDate());
            }

            if (groupe.getEndDate() != null && !updateGroupe.getEndDate().equals(groupe.getEndDate())) {
                updateGroupe.setEndDate(groupe.getEndDate());
            }

            if (groupe.getStatus() != null && !updateGroupe.getStatus().equals(groupe.getStatus())) {
                updateGroupe.setStatus(groupe.getStatus());
            }
        } catch (ResponseStatusException e) {
            new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Serveur Error: Unable to Update Groupe");
        }
        return updateGroupe;
    }

    public String deleteGroupeById(String id) {
        boolean groupeExist = groupeRepository.existsById(id);
        if (!groupeExist) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Error: Groupe with id %s not found in database ", id));
        }
        groupeRepository.deleteById(id);
        return "Groupe delete With Success";
    }

}