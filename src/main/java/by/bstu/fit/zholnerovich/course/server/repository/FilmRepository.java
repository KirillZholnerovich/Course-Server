package by.bstu.fit.zholnerovich.course.server.repository;

import by.bstu.fit.zholnerovich.course.server.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}
