package com.fichaje.user.domain.model;

public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    private Rol rol;
    private Sector sector;
    private boolean actualEmployed;

    public User(Long id, String name, String email, String password, Rol rol, Sector sector, boolean actualEmployed) {
        this.id = id;
        setName(name);
        setEmail(email);
        this.password = password;
        this.rol = rol;
        this.sector = sector;
        this.actualEmployed = actualEmployed;
    }

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

    public Rol getRol() {
        return rol;
    }

    public Sector getSector() {
        return sector;
    }

    public boolean isActualEmployed() {
        return actualEmployed;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email.");
        }
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public void setActualEmployed(boolean actualEmployed) {
        this.actualEmployed = actualEmployed;
    }
}
