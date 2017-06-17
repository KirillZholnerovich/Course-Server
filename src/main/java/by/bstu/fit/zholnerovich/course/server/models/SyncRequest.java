package by.bstu.fit.zholnerovich.course.server.models;

import by.bstu.fit.zholnerovich.course.server.entity.UserFilm;

public class SyncRequest {

    private Long date;
    private UserFilm viewed;

    public SyncRequest() {

    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public UserFilm getViewed() {
        return viewed;
    }

    public void setViewed(UserFilm viewed) {
        this.viewed = viewed;
    }
}
