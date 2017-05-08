package by.bstu.fit.zholnerovich.course.server.service;

import by.bstu.fit.zholnerovich.course.server.entity.Serials;
import by.bstu.fit.zholnerovich.course.server.repository.SerialsRepository;
import by.bstu.fit.zholnerovich.course.server.service.interfaces.ISerialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SerialsService implements ISerialsService {

    @Autowired
    private SerialsRepository repository;

    public List<Serials> getAll() {
        List<Serials> list = new ArrayList<Serials>();
        list.add(repository.findOne(1L));
        return list;
    }
}
