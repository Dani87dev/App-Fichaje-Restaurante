package com.fichaje.user.infrastructure.persistence;

import com.fichaje.user.domain.model.Rol;
import com.fichaje.user.domain.model.Sector;
import com.fichaje.user.domain.model.User;
import com.fichaje.user.domain.port.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// @Repository diu a Spring: "aquesta classe és un bean que gestiona dades"
// Spring la detecta i la fa disponible per injectar-la on calgui.
@Repository
public class UserRepositoryAdapter implements UserRepository {

    private final JpaUserRepository jpaRepo;

    public UserRepositoryAdapter(JpaUserRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public User save(User user) {
        UserEntity entity = toEntity(user);
        UserEntity saved = jpaRepo.save(entity);
        return toDomain(saved);
    }

    @Override
    public Optional<User> findById(Long id) {
        return jpaRepo.findById(id).map(this::toDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaRepo.findByEmail(email).map(this::toDomain);
    }

    @Override
    public List<User> findAll() {
        return jpaRepo.findAll().stream()
                .map(this::toDomain)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        jpaRepo.deleteById(id);
    }

    // --- Mètodes privats de conversió ---

    // Converteix User (domini) → UserEntity (JPA)
    // Fem servir .name() per convertir l'enum a String.
    // Ex: Rol.ADMIN → "ADMIN"
    private UserEntity toEntity(User user) {
        return new UserEntity(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getRol().name(),
                user.getSector().name(),
                user.isActualEmployed()
        );
    }

    // Converteix UserEntity (JPA) → User (domini)
    // Fem servir Rol.valueOf() per convertir String a enum.
    // Ex: "ADMIN" → Rol.ADMIN
    private User toDomain(UserEntity entity) {
        return new User(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPassword(),
                Rol.valueOf(entity.getRol()),
                Sector.valueOf(entity.getSector()),
                entity.isActualEmployed()
        );
    }
}