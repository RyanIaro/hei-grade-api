package hei.grade.school.service;

import hei.grade.school.mapper.UsersMapper;
import hei.grade.school.model.Users;
import hei.grade.school.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class UsersService {
    private UsersRepository usersRepository;

    // Get all users
    public List<Users> getAllUsers(){ return usersRepository.findAll(); }

    // Get user by id
    public Users getById(String id){ return usersRepository.findById(id).get(); }

    // Create user
    public Users createUser(UsersMapper usersMapper){
        Users user = new Users();
        try {
          user.setFirstName(usersMapper.getFirstName());
          user.setLastName(usersMapper.getLastName());
          user.setAddress(usersMapper.getAddress());
          user.setEmail(usersMapper.getEmail());
          user.setStatus(usersMapper.getStatus());
          user.setBirthDate(usersMapper.getBirthDate());
          user.setEntranceDatetime(usersMapper.getEntranceDatetime());
          user.setPhone(usersMapper.getPhone());
          user.setSex(usersMapper.getSex());
          user.setGroupe(usersRepository.findById(usersMapper.getId_groupe()).get().getGroupe());

          usersRepository.save(user);
       } catch (ResponseStatusException e) {
            new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Serveur Error: Unable to create user");
        }
        return usersRepository.findById(user.getId()).get();
    }

    // Update user
    public Users updateUser(String id, UsersMapper usersMapper){
        Boolean userExists = usersRepository.existsById(id);
        if(!userExists){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Error: user with id %s not found in database ", id));
        }
        Users user = usersRepository.findById(id).get();
        try {
            user.setFirstName(usersMapper.getFirstName());
            user.setLastName(usersMapper.getLastName());
            user.setAddress(usersMapper.getAddress());
            user.setEmail(usersMapper.getEmail());
            user.setStatus(usersMapper.getStatus());
            user.setBirthDate(usersMapper.getBirthDate());
            user.setEntranceDatetime(usersMapper.getEntranceDatetime());
            user.setPhone(usersMapper.getPhone());
            user.setSex(usersMapper.getSex());
            user.setGroupe(usersRepository.findById(usersMapper.getId_groupe()).get().getGroupe());

            usersRepository.save(user);
        } catch (ResponseStatusException e) {
            new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Serveur Error: Unable to update user");
        }

        return usersRepository.findById(id).get();
    }

    // Delete user
    public String deleteUser(String id){
        Boolean userExists = usersRepository.existsById(id);
        if(!userExists){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Error: user with id %s not found in database ", id));
        }
        usersRepository.deleteById(id);
        return "User deleted with success";
    }

}
