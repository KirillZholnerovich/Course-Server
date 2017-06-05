package by.bstu.fit.zholnerovich.course.server.service.interfaces;

import by.bstu.fit.zholnerovich.course.server.entity.Episode;
import by.bstu.fit.zholnerovich.course.server.entity.Serial;
import by.bstu.fit.zholnerovich.course.server.entity.User;

import java.io.IOException;
import java.util.List;

public interface ISerialService {
    String login(String username, String password);
    List<Serial> getAllSerials(Long date);
    List<Episode> getAll();
    Serial getSerial();
    String returnString(String string);
    String getUser(String login);
}
