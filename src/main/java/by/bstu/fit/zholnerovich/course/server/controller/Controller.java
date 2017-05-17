package by.bstu.fit.zholnerovich.course.server.controller;

import by.bstu.fit.zholnerovich.course.server.entity.Episode;
import by.bstu.fit.zholnerovich.course.server.service.interfaces.ISerialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private ISerialService service;

    @RequestMapping(value = "/login", params = {"username", "password"}, method = RequestMethod.GET)
    @ResponseBody
    public String returnAnswer(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password){
        return service.answer(username, password);
    }

    @RequestMapping(value = "/serials/get/all", method = RequestMethod.GET)
    @ResponseBody
    public String returnSerials() throws IOException{
        return service.getSerials();
    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    @ResponseBody
    public List<Episode> getAll(){
        return service.getAll();
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
