package by.bstu.fit.zholnerovich.course.server.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "logs")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "action", nullable = false, length = 20)
    private String action;

    @Column(name = "database")
    private String database;

    @Column(name = "row_id")
    private Long rowId;

    @Column(name = "action_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Log() {

    }

    public Log(String action, String database, Long rowId, Date date) {
        this.action = action;
        this.database = database;
        this.rowId = rowId;
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

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public Long getRowId() {
        return rowId;
    }

    public void setRowId(Long rowId) {
        this.rowId = rowId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
