package by.bstu.fit.zholnerovich.course.server.repository;

import by.bstu.fit.zholnerovich.course.server.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
