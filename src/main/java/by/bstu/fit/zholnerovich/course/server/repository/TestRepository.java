package by.bstu.fit.zholnerovich.course.server.repository;

import by.bstu.fit.zholnerovich.course.server.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}
