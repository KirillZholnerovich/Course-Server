package by.bstu.fit.zholnerovich.course.server.service;

import by.bstu.fit.zholnerovich.course.server.entity.Test;
import by.bstu.fit.zholnerovich.course.server.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository repository;

    public List<Test> getAll() {
        return repository.findAll();
    }

    public Test getById(long id) {
        return repository.findOne(id);
    }

    public Test save(Test test) {
        return repository.saveAndFlush(test);
    }

    public void remove(long id) {
        repository.delete(id);
    }
}
