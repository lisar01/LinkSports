package Application.Model;

import javax.persistence.*;

@Entity
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="username", nullable=false)
    private User owner;
    private String text;

    public Publicacion() {}

}
