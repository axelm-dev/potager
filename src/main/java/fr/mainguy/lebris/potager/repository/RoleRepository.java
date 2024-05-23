package fr.mainguy.lebris.potager.repository;

import fr.mainguy.lebris.potager.entity.ERole;
import fr.mainguy.lebris.potager.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("SELECT r FROM Role r WHERE r.name = ?1")
    Role findByName(ERole eRole);
}
