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
    private String nombre;
    private String apellido;
    private String deporte;
    private String tipo;
    @OneToMany
    private List<long> contactos = new ArrayList<>();
    //private List<Message> mensajes = new ArrayList<>();

    public User() {}

    public User(String username, String password, String nombre, String apellido, String deporte, String tipo) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.deporte = deporte;
        this.tipo = tipo;
    }

    public long getId() {
        return this.id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() { return apellido; }
    public String getDeporte() {
        return deporte;
    }
    public String getTipo() { return tipo; }
}
