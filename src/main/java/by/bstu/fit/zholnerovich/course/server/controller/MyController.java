package by.bstu.fit.zholnerovich.course.server.controller;

import by.bstu.fit.zholnerovich.course.server.entity.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/hello")
public class MyController {

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public Test getHello(){
        return createMockTest();
    }

    private Test createMockTest() {
        Test test = new Test();
        test.setId(1);
        test.setDate(new Date());
        test.setTitle("First Title");

        return test;
    }

}
