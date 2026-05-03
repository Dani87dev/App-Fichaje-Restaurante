package com.fichaje.user.infrastructure.persistance;


import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;


    @Column(nullable = false)
    private String rol;

    
    @Column(nullable = false)
    private String sector;

    @Column(nullable = false)
    private boolean actualEmployed;

    // Constructor buit: JPA l'exigeix obligatòriament.
    // Quan JPA llegeix una fila de la BBDD, primer crea l'objecte buit
    // i després li va posant els valors camp per camp.
    public UserEntity() {
    }

    // Constructor complet: el fem servir nosaltres a l'adapter
    // quan volem convertir un User de domini a UserEntity.
    public UserEntity(Long id, String name, String email, String password,
                      String rol, String sector, boolean actualEmployed) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.rol = rol;
        this.sector = sector;
        this.actualEmployed = actualEmployed;
    }

    // Getters: els necessita l'adapter per convertir
    // de UserEntity cap a User de domini.
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRol() {
        return rol;
    }

    public String getSector() {
        return sector;
    }

    public boolean isActualEmployed() {
        return actualEmployed;
    }

}
