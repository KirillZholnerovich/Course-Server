package by.bstu.fit.zholnerovich.course.server.controller;

import by.bstu.fit.zholnerovich.course.server.entity.Users;
import by.bstu.fit.zholnerovich.course.server.service.interfaces.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private IUsersService service;

    @RequestMapping(value = "/login", params = {"username", "password"}, method = RequestMethod.GET)
    @ResponseBody
    public String returnAnswer(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password){
        return service.answer(username, password);
    }
//
//    @RequestMapping(value = "/testJson/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public Users getJsonString(@PathVariable("id") long testId){
//        return service.get(testId);
//    }
//
//    @RequestMapping(value = "/testJson", method = RequestMethod.POST)
//    @ResponseBody
//    public Users saveJsonString(@RequestBody Users test){
//        return service.save(test);
//    }
//
//    @RequestMapping(value = "/testJson/{id}", method = RequestMethod.DELETE)
//    @ResponseBody
//    public void delete(@PathVariable("id") long testId){
//        service.remove(testId);
//    }
}
