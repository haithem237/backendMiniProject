package miniprojet.example.miniproject.dto;

import miniprojet.example.miniproject.entity.CategorieEntity;
import miniprojet.example.miniproject.entity.ProduitEntity;
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


    private List<ProduitEntity> produitEntities;

    public static   CategorieDto toDto(CategorieEntity entity){
        return  CategorieDto.builder()
                .id(entity.getId())
                .name(entity.getNom())
                .qte(entity.getQte())
                .dateDeCreation(entity.getDateDeCreation())
                .dateDeModification(entity.getDateDeModification())
                .build();
    }

}
