package fr.mainguy.lebris.potager.entity;

import jakarta.persistence.*;
import java.util.Set;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String type;
    private String variety;
    private double spaceUse;

    @OneToMany(mappedBy = "plant", cascade = CascadeType.ALL)
    private Set<PlantInSquare> plantInSquares;
}
