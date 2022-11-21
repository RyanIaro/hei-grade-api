package hei.grade.school.controller;

import hei.grade.school.mapper.MentionMapper;
import hei.grade.school.mapper.UsersMapper;
import hei.grade.school.model.Mention;
import hei.grade.school.model.Users;
import hei.grade.school.service.MentionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MentionController {
    private MentionService mentionService;

    @GetMapping("/mentions")
    public List<Mention> getAllMentions(){ return mentionService.getAllMention(); }

    @GetMapping("/mention/{mention_id}")
    public Mention getMentionById(@PathVariable String mention_id){ return mentionService.getMentionById(mention_id); }

    @PostMapping("/mention")
    public Mention createMention(@RequestBody MentionMapper mentionMapper){ return mentionService.createMention(mentionMapper); }

    @PutMapping("/mention/{mention_id}")
    public Mention updateMention(
            @PathVariable String mention_id,
            @RequestBody MentionMapper mentionMapper
    ){
        return mentionService.updateMention(mention_id, mentionMapper);
    }

    @DeleteMapping("/mention/{mention_id}")
    public String deleteMention(@PathVariable String mention_id){ return mentionService.deleteMention(mention_id); }
}
