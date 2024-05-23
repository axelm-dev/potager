package fr.mainguy.lebris.potager.repository;

import fr.mainguy.lebris.potager.entity.Action;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepository extends JpaRepository <Action, Long> {
}
