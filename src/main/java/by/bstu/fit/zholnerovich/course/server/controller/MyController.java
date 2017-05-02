package by.bstu.fit.zholnerovich.course.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class MyController {

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public String getHello(ModelMap model){
        return "Hello";
    }

}
