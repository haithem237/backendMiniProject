package miniprojet.example.miniproject.service;

import static org.junit.jupiter.api.Assertions.*;
import miniprojet.example.miniproject.entity.Categories;
import miniprojet.example.miniproject.entity.Produit;
import miniprojet.example.miniproject.repository.CategoriesRepository;
import miniprojet.example.miniproject.repository.ProduitRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.*;


import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
class CategoriesServiceTest {

    @Autowired
    private   ProduitService prodServ;
    @Autowired
    private  CategoriesService categoriesService;
    @Autowired
    private  CategoriesRepository categoriesRepository;
    @Autowired
    private ProduitRepository produitRepository;




    @Test
    void SaveProduitSucces(){
        Categories categories = new Categories();
        Categories savedCategorie = categoriesService.create(categories);
        Produit expectedProduit = Produit.builder()
                .name("name prod")
                .qt(1)
                .disponible(true)
                .categories(savedCategorie)
                .build();
        Produit savedProduit = prodServ.create(expectedProduit, expectedProduit.getCategories().getId());
        assertNotNull(savedProduit);
        assertNotNull(expectedProduit.getName() , savedProduit.getName());


    }

    @Test
    void UpdateProduitSucces(){
        Categories categories = new Categories();
        categories.setName("aaa");
        Categories savedCategorie= categoriesService.create(categories);
        Produit produit = new Produit();
        produit.setName("name prodUpdate1");
        produit.setQt(33);
        produit.setDisponible(true);
        produit.setCategories(savedCategorie);
        long categorieId = savedCategorie.getId();
        Produit savedProd=prodServ.create(produit, categorieId);
        Produit upadateProduit = savedProd;
        produit = produitRepository.findById(savedProd.getId()).orElse(null);
        savedProd = prodServ.update(upadateProduit, categorieId);
        assertNotNull(upadateProduit);
        assertNotNull(upadateProduit.getName() , savedProd.getName());
    }
    @Test
    void DeleteProduitSucces(){
        Categories categories = new Categories();
        Categories savedCategorie = categoriesService.create(categories);
        Produit expectedProduit = Produit.builder()
                .id(49)
                .name("name prod")
                .qt(1)
                .disponible(true)
                .categories(savedCategorie)
                .build();
        Produit savedProd=prodServ.create(expectedProduit, expectedProduit.getCategories().getId());

        boolean isDelted= prodServ.delete(savedProd.getId());
        assertTrue(isDelted);
        Optional<Produit>optionalProduit=produitRepository.findById(savedProd.getId());
        assertFalse(optionalProduit.isPresent());
    }

    @Test
    void FindAllSucces() {
        List<Produit> foundProduit = prodServ.getAllListProduit();
        assertNotNull(foundProduit);

    }
    @Test
    void FindByIdSucces() {
        Produit produit = new Produit();
        Produit found = prodServ.findById(1L);

        assertNotNull(found);
        assertEquals( 10,produit.getId(), found.getId());

    }





}