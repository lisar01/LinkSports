package Application.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    private String username;
    private String password;
    private String nombre;
    private String apellido;
    private String deporte;
    private String tipo;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_follower",
            joinColumns = {@JoinColumn(name="user")},
            inverseJoinColumns={@JoinColumn(name="follower")}
    )
    @JsonIgnoreProperties("following")
    private List<User> followers = new ArrayList<>();

    @ManyToMany(mappedBy="followers", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("followers")
    private List<User> following = new ArrayList<>();

    public User() {}

    public User(String username, String password, String nombre, String apellido, String deporte, String tipo) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.deporte = deporte;
        this.tipo = tipo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDeporte() {
        return deporte;
    }
    public String getTipo() { return tipo; }
    public List<User> getFollowers() { return followers; }
    public List<User> getFollowing() { return following; }

    public void addFollower(User user) { followers.add(user); }
  
    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
  
}
