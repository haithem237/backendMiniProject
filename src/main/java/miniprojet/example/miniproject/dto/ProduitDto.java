package miniprojet.example.miniproject.dto;

import miniprojet.example.miniproject.entity.Categories;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class ProduitDto {
    private long id;

    private String nom;

    private int qte;

    private Boolean disponible;

    private LocalDate dateDeCreation;

    private LocalDate dateDeModification;



    Categories categorieEntity;
}
