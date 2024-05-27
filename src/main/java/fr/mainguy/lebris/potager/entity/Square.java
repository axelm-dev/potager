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
public class Square {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pottage_id", nullable = false)
    private Pottage pottage;

    private double surface;
    private String ground_type;
    private String exposition_type;

    @OneToMany(mappedBy = "square", cascade = CascadeType.ALL)
    private Set<PlantInSquare> plantInSquares;
    }