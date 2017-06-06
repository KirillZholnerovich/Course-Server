package by.bstu.fit.zholnerovich.course.server.service;

import by.bstu.fit.zholnerovich.course.server.entity.Film;
import by.bstu.fit.zholnerovich.course.server.entity.Log;
import by.bstu.fit.zholnerovich.course.server.entity.User;
import by.bstu.fit.zholnerovich.course.server.entity.UserFilm;
import by.bstu.fit.zholnerovich.course.server.repository.FilmRepository;
import by.bstu.fit.zholnerovich.course.server.repository.LogRepository;
import by.bstu.fit.zholnerovich.course.server.repository.UserFilmRepository;
import by.bstu.fit.zholnerovich.course.server.repository.UserRepository;
import by.bstu.fit.zholnerovich.course.server.service.interfaces.ISerialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class SerialServiceImpl implements ISerialService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private LogRepository logRepository;

    @Autowired
    private UserFilmRepository userFilmRepository;

    public User login(String username, String password) {
        List<User> list = userRepository.findAll();
        for (User user : list){
            if (user.getLogin().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return new User(-1L, "Пользователь не найден", "", "");
    }

    public User registration(User user) {
        for (User existUser : userRepository.findAll()) {
            if(user.getLogin().equals(existUser.getLogin())){
                return new User(-1L, "Пользователь с таким именем уже существует", "", "");
            }
        }
        userRepository.saveAndFlush(user);
        for (User existUser : userRepository.findAll()) {
            if(user.getLogin().equals(existUser.getLogin())){
                return existUser;
            }
        }
        return new User(-1L, "Неизвестная ошибка", "", "");
    }

    public List<Film> getAllFilmsById(Long id){
        List<Film> list = new ArrayList<Film>();
        for (Film film: filmRepository.findAll()) {
            for (User user :film.getUsers()) {
                if (user.getId() == id){
                    list.add(film);
                }
            }
        }
        return list;
    }

    public List<Film> getAllFilms(){
        return filmRepository.findAll();
    }

    public String addToViewed(Long userId, Long filmId){
        userFilmRepository.saveAndFlush(new UserFilm(userId, filmId));
        return "lol";
    }
}
