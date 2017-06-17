package by.bstu.fit.zholnerovich.course.server.models;

import by.bstu.fit.zholnerovich.course.server.entity.Film;
import by.bstu.fit.zholnerovich.course.server.entity.UserFilm;

import java.util.ArrayList;
import java.util.List;

public class SyncData {

    private List<Film> films;
    private List<UserFilm> viewed;

    public SyncData() {

    }

    public List<Film> getFilms() {
        if (films == null){
            films = new ArrayList<Film>();
        }
        return films;
    }

    public List<UserFilm> getViewed() {
        if (viewed == null){
            viewed = new ArrayList<UserFilm>();
        }
        return viewed;
    }
}
