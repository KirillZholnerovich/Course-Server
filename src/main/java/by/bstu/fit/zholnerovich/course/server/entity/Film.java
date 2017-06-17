package by.bstu.fit.zholnerovich.course.server.entity;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "films")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "subname", length = 100)
    private String subname;

    @Column(name = "rating", nullable = false)
    private short rating;

    @Column(name = "year", nullable = false, length = 5)
    private String year;

    @Column(name = "time", nullable = false)
    private int time;

    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @ManyToMany(mappedBy = "films")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private List<User> users = new ArrayList<User>();

    public Film() {

    }

    public Film(Long id) {
        this.id = id;
    }

    public Film(String name, String subname, short rating, String year, int time, String description, List<User> users) {
        this.name = name;
        this.subname = subname;
        this.rating = rating;
        this.year = year;
        this.time = time;
        this.description = description;
        this.users = users;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
