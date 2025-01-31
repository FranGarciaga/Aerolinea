package org.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuarios {

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles roles;

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @Column(nullable = false, unique = true)
    private String username;

    @Setter
    @Getter
    @Column(nullable = false)
    private String password;
    
    @Setter
    @Getter
    @Column(nullable = false)
    private String role;

    @Setter
    @Getter
    private String profileImage;

    @Setter
    @Getter
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservas> reservas;

    public Usuarios(Long usuariosId) {
    }

    public String getUserName() {
        return username;
    }

    public Roles[] getRoles() {
        return new Roles[0];
    }
}