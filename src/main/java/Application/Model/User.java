package Application.Model;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String username;
    private String password;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return this.id;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() { return password; }
}
