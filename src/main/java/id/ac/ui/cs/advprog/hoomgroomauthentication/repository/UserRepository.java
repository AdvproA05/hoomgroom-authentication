package id.ac.ui.cs.advprog.hoomgroomauthentication.repository;

import id.ac.ui.cs.advprog.hoomgroomauthentication.models.*;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
