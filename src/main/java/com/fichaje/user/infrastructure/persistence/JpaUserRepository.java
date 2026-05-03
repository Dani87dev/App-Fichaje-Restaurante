package com.fichaje.user.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// JpaRepository<UserEntity, Long> vol dir:
// - UserEntity: la classe que mapeja a la taula
// - Long: el tipus de la primary key (id)
//
// Amb això ja tens gratis: save(), findById(), findAll(), deleteById()
// Només cal afegir mètodes extra si necessites queries especials.
public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {

    // Spring veu el nom "findByEmail" i genera automàticament:
    // SELECT * FROM users WHERE email = ?
    // No has d'escriure la query, ho fa sol pel nom del mètode.
    Optional<UserEntity> findByEmail(String email);
}