package by.bstu.fit.zholnerovich.course.server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "episodes_log")
public class EpisodeLog {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @Column(name = "action", nullable = false, length = 20)
    private String action;

    @ManyToOne
    @JoinColumn(name = "episode_id")
    private Episode episode;

    @Column(name = "action_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public EpisodeLog() {
    }

    public EpisodeLog(String action, Episode episode, Date date) {
        this.action = action;
        this.episode = episode;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Episode getEpisode() {
        return episode;
    }

    public void setEpisode(Episode episode) {
        this.episode = episode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
