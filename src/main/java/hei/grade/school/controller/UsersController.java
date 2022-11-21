package hei.grade.school.controller;

import hei.grade.school.mapper.UsersMapper;
import hei.grade.school.model.Users;
import hei.grade.school.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UsersController {

    private UsersService usersService;

    @GetMapping("/users")
    public List<Users> getAllUsers(){ return usersService.getAllUsers(); }

    @GetMapping("/user/{user_id}")
    public Users getUserById(@PathVariable String user_id){ return usersService.getById(user_id); }

    @PostMapping("/user")
    public Users createUser(@RequestBody UsersMapper usersMapper){ return usersService.createUser(usersMapper); }

    @PutMapping("/user/{user_id}")
    public Users updateUser(
            @PathVariable String user_id,
            @RequestBody UsersMapper usersMapper
    ){
        return usersService.updateUser(user_id, usersMapper);
    }

    @DeleteMapping("/user/{user_id}")
    public String deleteUser(@PathVariable String user_id){ return usersService.deleteUser(user_id); }

}
