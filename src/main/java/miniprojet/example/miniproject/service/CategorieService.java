package miniprojet.example.miniproject.service;


import miniprojet.example.miniproject.entity.CategorieEntity;

import java.util.List;
import java.util.Optional;

public interface CategorieService {

    /* List<categories>.finAllCategories();  */

    List<CategorieEntity> findAllCategorie();
    Optional<CategorieEntity> findById(Long id);
    CategorieEntity saveCategorie(CategorieEntity categorieEntity);
    CategorieEntity updateCategorie(CategorieEntity categorieEntity);
    void deleteCategorie(Long id);

}
