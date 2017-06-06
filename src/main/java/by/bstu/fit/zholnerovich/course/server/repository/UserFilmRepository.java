package by.bstu.fit.zholnerovich.course.server.repository;

import by.bstu.fit.zholnerovich.course.server.entity.UserFilm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFilmRepository extends JpaRepository<UserFilm, Long> {
}
