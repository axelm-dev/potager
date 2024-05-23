package fr.mainguy.lebris.potager.repository;

import fr.mainguy.lebris.potager.entity.Plant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends CrudRepository<Plant, Long> {
}
