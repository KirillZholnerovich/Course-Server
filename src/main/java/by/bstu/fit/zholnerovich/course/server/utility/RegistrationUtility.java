package by.bstu.fit.zholnerovich.course.server.utility;

import by.bstu.fit.zholnerovich.course.server.repository.UserRepository;
import by.bstu.fit.zholnerovich.course.server.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class RegistrationUtility {

    @Autowired
    private UserRepository userRepository;

    private static final String ALREADY_EXISTS = "Пользователь с таким именем уже существует";
    private static final String SUCCESSFUL_REGISTRATION = "Пользователь успешно зарегистрирован";

    private List<User> list;

    public RegistrationUtility(){

    }

    public String registrateUser(String userData){

        list = userRepository.findAll();
        for (User user : list) {
            if(user.getLogin().equals(userData.split(":")[0]))
                return ALREADY_EXISTS;
        }
        userRepository.saveAndFlush(new User(userData.split(":")[0], userData.split(":")[1],userData.split(":")[2], new Date()));
        return SUCCESSFUL_REGISTRATION;
    }
}
