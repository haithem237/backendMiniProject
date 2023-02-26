package miniprojet.example.miniproject.dto;


import miniprojet.example.miniproject.entity.Produit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CategorieDto  {

    private long id;
    private String name;
    private int qte;
    private LocalDate dateDeCreation;
    private LocalDate dateDeModification;


    private List<Produit> produitEntities;


}
