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

import hei.grade.school.model.Groupe;
import hei.grade.school.service.GroupeService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/groupes")
public class GroupeController {
    private final GroupeService groupeService;

    @PostMapping // Create Groupe
    public Groupe createGroupe(
            @RequestBody() Groupe groupe) throws ResponseStatusException {
        return groupeService.createGroupe(groupe);
    }

    @GetMapping // Get all groupe
    public List<Groupe> getAllGroupe() throws ResponseStatusException {
        return groupeService.getAllGroupe();
    }

    @GetMapping("/{id}") // Get groupe by id
    public Groupe getGroupeById(
            @PathVariable("id") String id) throws ResponseStatusException {
        return groupeService.getGroupeById(id);
    }

    @PutMapping("/{id}") // Update groupe by id
    public Groupe updateGroupeById(
            @PathVariable("id") String id,
            @RequestBody() Groupe groupe) throws ResponseStatusException {
        return groupeService.updateGroupeById(id, groupe);
    }

    @DeleteMapping("/{id}") // Delete groupe by id
    public String deleteGroupeById(
            @PathVariable("id") String id) throws ResponseStatusException {
        return groupeService.deleteGroupeById(id);
    }
}
