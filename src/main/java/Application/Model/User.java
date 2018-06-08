package Application.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String username;
    private String password;
    /*private String nombre;
    private String apellido;
    private String tipo;
    private String deporte;
    private List<User> contactos = new ArrayList<User>();
    @OneToMany
    private List<Mensaje> mensajes = new ArrayList<Mensaje>*/

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
