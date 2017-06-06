package by.bstu.fit.zholnerovich.course.server.service.interfaces;

import by.bstu.fit.zholnerovich.course.server.entity.Film;
import by.bstu.fit.zholnerovich.course.server.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

public interface ISerialService {
    User login(String username, String password);
    User registration(User user);

    List<Film> getAllFilmsById(Long id);
    List<Film> getAllFilms();

    String addToViewed(Long userId, Long filmId);
}
