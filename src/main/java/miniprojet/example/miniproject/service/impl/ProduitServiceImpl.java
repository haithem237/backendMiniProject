package miniprojet.example.miniproject.service.impl;


import miniprojet.example.miniproject.entity.CategorieEntity;
import miniprojet.example.miniproject.entity.ProduitEntity;
import miniprojet.example.miniproject.repository.CategorieRepository;
import miniprojet.example.miniproject.repository.ProduitRepository;
import miniprojet.example.miniproject.service.ProduitService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;

@Service

public class ProduitServiceImpl implements ProduitService  {

    @Autowired
    CategorieRepository categorieRepository;
    private final ProduitRepository produitRepository;



    public ProduitServiceImpl(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @Override
    public List<ProduitEntity> findAllProduit()
    {
        return produitRepository.findAll();
    }


    @Override
    public Optional<ProduitEntity> findById(Long id) {
        return produitRepository.findById(id);
    }




    @Override
    public ProduitEntity saveProduit(ProduitEntity produitEntity,Long id ) {
        CategorieEntity cat =  categorieRepository.findById(id).orElse(null);
        produitEntity.setCategorie(cat);
        produitEntity.setDateDeCreation(LocalDate.now());
        produitEntity.setDateDeModification(LocalDate.now());
        return produitRepository.save(produitEntity);
    }


    @Override
    public ProduitEntity updateProduit(ProduitEntity produitEntity) {

        produitEntity.setDateDeModification(LocalDate.now());

        return produitRepository.save(produitEntity);
    }

    @Override
    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);

    }

}
