package by.bstu.fit.zholnerovich.course.server.service;

import by.bstu.fit.zholnerovich.course.server.entity.Film;
import by.bstu.fit.zholnerovich.course.server.entity.Log;
import by.bstu.fit.zholnerovich.course.server.entity.User;
import by.bstu.fit.zholnerovich.course.server.entity.UserFilm;
import by.bstu.fit.zholnerovich.course.server.models.SyncData;
import by.bstu.fit.zholnerovich.course.server.repository.FilmRepository;
import by.bstu.fit.zholnerovich.course.server.repository.LogRepository;
import by.bstu.fit.zholnerovich.course.server.repository.UserFilmRepository;
import by.bstu.fit.zholnerovich.course.server.service.interfaces.ISerialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SerialServiceImpl implements ISerialService {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private UserFilmRepository userFilmRepository;

    @Autowired
    private LogRepository logRepository;

    public SyncData synchronization(Long time) {
        SyncData data = new SyncData();

        if(time == 0) {
            data.getFilms().addAll(filmRepository.findAll());
            data.getViewed().addAll(userFilmRepository.findAll());
        } else {
            List<Log> logList = new ArrayList<Log>();

            for (Log log: logRepository.findAll()) {
                if (log.getDate().getTime() > time)
                    logList.add(log);
            }

            for (Map.Entry<Long, String> entry : getUpdateLogs(time, "films", logList).entrySet()) {
                Film film = filmRepository.findOne(entry.getKey());
                if(entry.getValue().equals("DELETE"))
                    film = new Film(entry.getKey() * -1);
                data.getFilms().add(film);
            }

            for (Map.Entry<Long, String> entry : getUpdateLogs(time, "users_films", logList).entrySet()) {
                UserFilm userFilm = userFilmRepository.findOne(entry.getKey());
                if(entry.getValue().equals("DELETE"))
                    userFilm = new UserFilm(entry.getKey() * -1);
                data.getViewed().add(userFilm);
            }
        }
        return data;
    }

    private HashMap<Long, String> getUpdateLogs(Long time, String table, List<Log> list){
        HashMap<Long, String> map = new HashMap<Long, String>();

        HashMap<String, Integer> priority = new HashMap<String, Integer>();
        priority.put("DELETE", 3);
        priority.put("UPDATE", 2);
        priority.put("INSERT", 1);

        for (Log log: list){
            if (log.getDatabase().equals(table)){
                try{
                    map.put(log.getRowId(), log.getAction());
                } catch (Exception e){
                    if (priority.get(map.get(log.getRowId())) < priority.get(log.getAction())){
                        map.remove(log.getRowId());
                        map.put(log.getRowId(), log.getAction());
                    }
                }
            }
        }
        return map;
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

    public SyncData addToViewed(Long date, Long userId, Long filmId){
        List<UserFilm> list = userFilmRepository.findAll();

        for (UserFilm viewed: list){
            if (userId == viewed.getUserId() && filmId == viewed.getFilmId()){
                userFilmRepository.delete(viewed);
                return synchronization(date);
            }
        }
        userFilmRepository.saveAndFlush(new UserFilm(userId, filmId));
        return synchronization(date);
    }
}
