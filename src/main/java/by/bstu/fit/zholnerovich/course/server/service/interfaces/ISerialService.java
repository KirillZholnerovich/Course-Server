package by.bstu.fit.zholnerovich.course.server.service.interfaces;

import by.bstu.fit.zholnerovich.course.server.entity.Episode;
import by.bstu.fit.zholnerovich.course.server.entity.User;

import java.io.IOException;
import java.util.List;

public interface ISerialService {
    String answer(String username, String password);
    String getSerials() throws IOException;
    List<Episode> getAll();
}
