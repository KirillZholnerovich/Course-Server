package by.bstu.fit.zholnerovich.course.server.entity;

import javax.persistence.*;

@Entity
@Table(name = "serials")
public class Serial {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "subname", nullable = false, length = 100)
    private String subname;

    public Serial() {
    }

    public Serial(Long id, String name, String subname) {
        this.id = id;
        this.name = name;
        this.subname = subname;
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
}
