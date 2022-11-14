package hei.grade.school.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {
    @GetMapping("/")
    public String helloString() {
        return "<h1>Hello Assembly</h1>";
    }
}
