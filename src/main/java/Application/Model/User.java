package Application.Model;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String username;

    public User() {}

    public User(String username) {
        this.username = username;
    }

    public long getId() {
        return this.id;
    }

    public String getUsername() {
        return username;
    }
}
