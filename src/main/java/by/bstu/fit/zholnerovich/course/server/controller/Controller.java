package by.bstu.fit.zholnerovich.course.server.controller;

import by.bstu.fit.zholnerovich.course.server.entity.Episode;
import by.bstu.fit.zholnerovich.course.server.entity.Serial;
import by.bstu.fit.zholnerovich.course.server.entity.User;
import by.bstu.fit.zholnerovich.course.server.service.interfaces.ISerialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private ISerialService service;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody String userData){
        return service.login(userData.split(":")[0], userData.split(":")[1]);
    }

    @RequestMapping(value = "/serials/get/all", method = RequestMethod.POST)
    @ResponseBody
    public List<Serial> returnSerials(@RequestBody Long date) throws IOException{
        return service.getAllSerials(date);
    }

    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Episode> getAll(){
        return service.getAll();
    }

    @RequestMapping(value = "/getSerial", method = RequestMethod.GET)
    @ResponseBody
    public Serial getSerial(){
        Serial serial = service.getSerial();
        return service.getSerial();
    }

    @RequestMapping(value = "/get/user", method = RequestMethod.POST)
    @ResponseBody
    public String getUser(@RequestBody String login){
        return service.getUser(login);
    }

    @RequestMapping(value = "/somePost", method = RequestMethod.POST)
    @ResponseBody
    public String saveJsonString(@RequestBody String str){
        return service.returnString(str);
    }


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
