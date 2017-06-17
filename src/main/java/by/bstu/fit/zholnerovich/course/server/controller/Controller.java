package by.bstu.fit.zholnerovich.course.server.controller;

import by.bstu.fit.zholnerovich.course.server.entity.Film;
import by.bstu.fit.zholnerovich.course.server.entity.User;
import by.bstu.fit.zholnerovich.course.server.entity.UserFilm;
import by.bstu.fit.zholnerovich.course.server.models.SyncData;
import by.bstu.fit.zholnerovich.course.server.models.SyncRequest;
import by.bstu.fit.zholnerovich.course.server.service.interfaces.ISerialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {

    @Autowired
    private ISerialService service;

    @RequestMapping(value = "/sync", method = RequestMethod.POST)
    @ResponseBody
    public SyncData addToViewed(@RequestBody Long time){
        return service.synchronization(time);
    }

    @RequestMapping(value = "/films/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Film> getAllFilmsById(@PathVariable("id") long id){
        return service.getAllFilmsById(id);
    }

    @RequestMapping(value = "/films", method = RequestMethod.GET)
    @ResponseBody
    public List<Film> getAllFilms(){
        return service.getAllFilms();
    }

    @RequestMapping(value = "/sync/viewed", method = RequestMethod.POST)
    @ResponseBody
    public SyncData addToViewed(@RequestBody SyncRequest viewed){
        return service.addToViewed(viewed.getDate(), viewed.getViewed().getUserId(), viewed.getViewed().getFilmId());
    }

//    @RequestMapping(value = "/sync/viewed",params = { "userId", "filmId" }, method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
//    @ResponseBody
//    public String addToViewed(@RequestParam(value = "userId") long userId, @RequestParam(value = "filmId") long filmId){
//        return service.addToViewed(userId, filmId);
//    }
}
