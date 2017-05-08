package by.bstu.fit.zholnerovich.course.server.service;

import by.bstu.fit.zholnerovich.course.server.entity.Users;
import by.bstu.fit.zholnerovich.course.server.repository.UsersRepository;
import by.bstu.fit.zholnerovich.course.server.service.interfaces.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService implements IUsersService {

    @Autowired
    private UsersRepository repository;


    public String answer(String username, String password) {
        List<Users> list = repository.findAll();
        for (Users user : list){
            if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                return "Successful";
            }
            else return "SUKA BLYAT'!";
        }
        return "Error!";
    }
}
