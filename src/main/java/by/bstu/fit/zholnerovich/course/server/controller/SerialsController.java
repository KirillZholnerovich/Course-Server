package by.bstu.fit.zholnerovich.course.server.controller;

import by.bstu.fit.zholnerovich.course.server.entity.Serials;
import by.bstu.fit.zholnerovich.course.server.service.interfaces.ISerialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SerialsController {

    @Autowired
    private ISerialsService service;

    @RequestMapping(value = "/psa", method = RequestMethod.GET)
    @ResponseBody
    public List<Serials> getAll(){
        return service.getAll();
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
