package by.bstu.fit.zholnerovich.course.server.entity;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "serials")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Serial {

    @Id
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "subname", length = 100)
    private String subname;

    @Column(name = "rating", nullable = false)
    private short rating;

    @Column(name = "seasons", nullable = false)
    private short seasons;

    @Column(name = "year", nullable = false, length = 5)
    private String year;

    @Column(name = "status", nullable = false)
    private boolean status;

    @OneToMany(mappedBy = "serial", cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Episode> episodes = new ArrayList<Episode>();

    @ManyToMany(mappedBy = "serials")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private List<User> users = new ArrayList<User>();

    public Serial() {

    }

    public Serial(Long id, String name, String subname, short rating, short seasons, String year, boolean status) {
        this.id = id;
        this.name = name;
        this.subname = subname;
        this.rating = rating;
        this.seasons = seasons;
        this.year = year;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    public short getRating() {
        return rating;
    }

    public void setRating(short rating) {
        this.rating = rating;
    }

    public short getSeasons() {
        return seasons;
    }

    public void setSeasons(short seasons) {
        this.seasons = seasons;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
