package by.bstu.fit.zholnerovich.course.server.controller;

import by.bstu.fit.zholnerovich.course.server.entity.Test;
import by.bstu.fit.zholnerovich.course.server.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/hello")
public class TestController {

    @Autowired
    private TestRepository testRepository;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public Test getHello(){
        List<Test> list = testRepository.findAll();
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
