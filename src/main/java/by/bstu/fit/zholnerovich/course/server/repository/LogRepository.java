package by.bstu.fit.zholnerovich.course.server.repository;

import by.bstu.fit.zholnerovich.course.server.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Long> {
}
