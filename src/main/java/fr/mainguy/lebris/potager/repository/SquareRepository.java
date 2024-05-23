package fr.mainguy.lebris.potager.repository;

import fr.mainguy.lebris.potager.entity.Square;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SquareRepository extends JpaRepository <Square, Long> {
}
