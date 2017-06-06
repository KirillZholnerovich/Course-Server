package by.bstu.fit.zholnerovich.course.server.controller;

import by.bstu.fit.zholnerovich.course.server.entity.Film;
import by.bstu.fit.zholnerovich.course.server.entity.User;
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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public User login(@RequestBody Map<String, String> map){
        return service.login(map.get("login"), map.get("password"));
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    @ResponseBody
    public User registration(@RequestBody User user) {
        return service.registration(user);
    }

    @RequestMapping(value = "/loginweb", params = { "login", "password" }, method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public User loginWeb(@RequestParam(value = "login") String login, @RequestParam(value = "password") String password){
        return service.login(login, password);
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

    @RequestMapping(value = "/viewed/set",params = { "userId", "filmId" }, method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public String addToViewed(@RequestParam(value = "userId") long userId, @RequestParam(value = "filmId") long filmId){
        return service.addToViewed(userId, filmId);
    }
}
