package by.bstu.fit.zholnerovich.course.server.entity;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login", nullable = false, length = 50)
    private String login;

    @Column(name = "password", nullable = false, length = 50)
    @JsonIgnore
    private String password;

    @Column(name = "email", nullable = false, length = 50)
    @JsonIgnore
    private String email;

    @Column(name = "last_sync")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastSync;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnoreProperties("episodes")
    @JoinTable(name="users_serials",
            joinColumns={@JoinColumn(name="user_id", referencedColumnName="id"), },
            inverseJoinColumns={@JoinColumn(name="serial_id", referencedColumnName="id")})
    private List<Serial> serials = new ArrayList<Serial>();

    public User() {
    }

    public User(String login, String password, String email, Date date ) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.lastSync = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLastSync() {
        return lastSync;
    }

    public void setLastSync(Date lastSync) {
        this.lastSync = lastSync;
    }

    public List<Serial> getSerials() {
        return serials;
    }

    public void setSerials(List<Serial> serials) {
        this.serials = serials;
    }
}
