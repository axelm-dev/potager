package fr.mainguy.lebris.potager.repository;

import fr.mainguy.lebris.potager.entity.Pottage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PottageRepository extends JpaRepository<Pottage,Long> {
}
