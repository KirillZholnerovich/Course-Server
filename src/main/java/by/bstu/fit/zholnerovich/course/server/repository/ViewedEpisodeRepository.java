package by.bstu.fit.zholnerovich.course.server.repository;

import by.bstu.fit.zholnerovich.course.server.entity.ViewedEpisode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViewedEpisodeRepository extends JpaRepository<ViewedEpisode, Long> {
}
