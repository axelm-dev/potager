package fr.mainguy.lebris.potager.repository;

import fr.mainguy.lebris.potager.entity.Plant;
import org.springframework.data.repository.CrudRepository;

public interface PlantRepository extends CrudRepository<Plant, Long> {
}
