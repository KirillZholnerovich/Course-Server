package by.bstu.fit.zholnerovich.course.server.service;

import by.bstu.fit.zholnerovich.course.server.entity.Test;

import java.util.List;

public interface TestService {
    List<Test> getAll();
    Test getById(long id);
    Test save(Test test);
    void remove(long id);
}
