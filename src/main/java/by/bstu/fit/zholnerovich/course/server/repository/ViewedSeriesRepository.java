package by.bstu.fit.zholnerovich.course.server.repository;

import by.bstu.fit.zholnerovich.course.server.entity.ViewedSerial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViewedSeriesRepository extends JpaRepository<ViewedSerial, Long> {
}
