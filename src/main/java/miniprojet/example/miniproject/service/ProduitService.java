package miniprojet.example.miniproject.service;

import miniprojet.example.miniproject.entity.ProduitEntity;

import java.util.List;
import java.util.Optional;
public interface ProduitService {

    /* List<categories>.finAllCategories();  */

    List<ProduitEntity> findAllProduit();

    Optional<ProduitEntity> findById(Long id);
    ProduitEntity saveProduit(ProduitEntity produitEntity, Long id);
    ProduitEntity updateProduit(ProduitEntity produitEntity);
    void deleteProduit(Long id);

}
