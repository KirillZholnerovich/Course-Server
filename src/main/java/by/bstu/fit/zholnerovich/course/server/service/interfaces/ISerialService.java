package by.bstu.fit.zholnerovich.course.server.service.interfaces;

import by.bstu.fit.zholnerovich.course.server.entity.Film;
import by.bstu.fit.zholnerovich.course.server.entity.User;
import by.bstu.fit.zholnerovich.course.server.models.SyncData;
import com.sun.corba.se.impl.orbutil.concurrent.Sync;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

public interface ISerialService {
    SyncData synchronization(Long time);

    List<Film> getAllFilmsById(Long id);
    List<Film> getAllFilms();

    SyncData addToViewed(Long date, Long userId, Long filmId);
}
