package by.bstu.fit.zholnerovich.course.server.repository;

import by.bstu.fit.zholnerovich.course.server.entity.Serial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerialsRepository extends JpaRepository<Serial, Long> {
}
