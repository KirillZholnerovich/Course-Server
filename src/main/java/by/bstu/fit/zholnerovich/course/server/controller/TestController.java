package by.bstu.fit.zholnerovich.course.server.controller;

import by.bstu.fit.zholnerovich.course.server.entity.Test;
import by.bstu.fit.zholnerovich.course.server.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private TestService service;

    @RequestMapping(value = "/testJson", method = RequestMethod.GET)
    @ResponseBody
    public List<Test> getAllJsonStrings(){
        return service.getAll();
    }

    @RequestMapping(value = "/testJson/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Test getJsonString(@PathVariable("id") long testId){
        return service.getById(testId);
    }

    @RequestMapping(value = "/testJson", method = RequestMethod.POST)
    @ResponseBody
    public Test saveJsonString(@RequestBody Test test){
        return service.save(test);
    }

    @RequestMapping(value = "/testJson/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable("id") long testId){
        service.remove(testId);
    }
}
