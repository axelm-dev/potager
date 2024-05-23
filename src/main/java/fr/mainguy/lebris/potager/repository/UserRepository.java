package fr.mainguy.lebris.potager.repository;

import fr.mainguy.lebris.potager.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    User findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    boolean existsByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    boolean existsByEmail(String email);
}
