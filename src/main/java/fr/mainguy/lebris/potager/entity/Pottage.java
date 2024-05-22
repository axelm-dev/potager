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
public class Pottage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String place;
    private String name;
    private double surface;
    private String city;

    @OneToMany(mappedBy = "pottage", cascade = CascadeType.ALL)
    private Set<Square> squares;
}
