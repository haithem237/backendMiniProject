package miniprojet.example.miniproject.dto;

import miniprojet.example.miniproject.entity.CategorieEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class ProduitDto {
    private long id;

    private String Nom;

    private int Qte;

    private Boolean Disponible;

    private LocalDate dateDeCreation;

    private LocalDate dateDeModification;



    CategorieEntity categorieEntity;
}
