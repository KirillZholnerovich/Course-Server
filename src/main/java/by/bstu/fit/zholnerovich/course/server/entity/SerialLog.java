package by.bstu.fit.zholnerovich.course.server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "serials_log")
public class SerialLog {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @Column(name = "action", nullable = false, length = 20)
    private String action;

    @ManyToOne
    @JoinColumn(name = "serial_id")
    private Serial serial;

    @Column(name = "action_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public SerialLog() {

    }

    public SerialLog(String action, Serial serial, Date date) {
        this.action = action;
        this.serial = serial;
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

    public Serial getSerial() {
        return serial;
    }

    public void setSerial(Serial serial) {
        this.serial = serial;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
