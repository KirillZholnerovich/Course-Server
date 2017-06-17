package by.bstu.fit.zholnerovich.course.server.utility;

import by.bstu.fit.zholnerovich.course.server.entity.Film;
import by.bstu.fit.zholnerovich.course.server.entity.Log;
import by.bstu.fit.zholnerovich.course.server.entity.User;
import by.bstu.fit.zholnerovich.course.server.entity.UserFilm;
import by.bstu.fit.zholnerovich.course.server.repository.FilmRepository;
import by.bstu.fit.zholnerovich.course.server.repository.LogRepository;
import by.bstu.fit.zholnerovich.course.server.repository.UserFilmRepository;
import by.bstu.fit.zholnerovich.course.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RegistrationUtility {

    private static final String ALREADY_EXISTS = "Пользователь с таким именем уже существует";
    private static final String USER_NOT_EXISTS = "Пользователь с таким именем не существует";

    @Autowired
    private UserRepository userRepository;

    public RegistrationUtility(){

    }

    public String setResponseBody(String request){
        String params[] = request.split(":");

        if (params.length == 2)
            return login(params);
        else if (params.length == 3)
            return registration(params);
        else
            return "-1:error:error:error";

    }

    private String registration(String params[]){
        String login = params[0];
        String password = params[1];
        String email = params[2];

        List<User> list = userRepository.findAll();
        for (User user: list) {
            if(user.getLogin().equals(login))
                return "-1:" + ALREADY_EXISTS + ":error:error";
        }
        userRepository.saveAndFlush(new User(login, password, email));

        list = userRepository.findAll();
        for (User user: list) {
            if(user.getLogin().equals(login))
                return user.getId() + ":" + user.getLogin() + ":" + user.getPassword() + ":" + user.getEmail();
        }
        return "-1:error:error:error";
    }

    private String login(String params[]){
        String login = params[0];
        String password = params[1];

        List<User> list = userRepository.findAll();
        for (User user: list) {
            if(user.getLogin().equals(login) && user.getPassword().equals(password))
                return user.getId() + ":" + user.getLogin() + ":" + user.getPassword() + ":" + user.getEmail();
        }
        return "-1:" + USER_NOT_EXISTS + ":error:error";
    }
}
