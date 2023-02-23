package miniprojet.example.miniproject.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import miniprojet.example.miniproject.entity.CategorieEntity;
import miniprojet.example.miniproject.repository.CategorieRepository;
import miniprojet.example.miniproject.service.CategorieService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest

class ProduitServiceImplTest {


    @Autowired
    private CategorieRepository categorieRepository;

    @Test
    public void TestCreateCategorie() {
        CategorieEntity categorie = new CategorieEntity();
        categorieRepository.save(categorie);
    }


    @Test
    public void TestFindAllCategorie() {
        List<CategorieEntity> cat = categorieRepository.findAll();
        for (CategorieEntity c:cat)
            System.out.println(c);

    }

    @Test
    public void testFindCategorie() {
        CategorieEntity cat = categorieRepository.findById(1L).get();
        System.out.println(cat);
    }



    @Test
    public void testUpdateCateogire() {
        CategorieEntity p = categorieRepository.findById(1L).get();
        p.setNom("Test Unitaire Success");
        p.setQte(111);
        categorieRepository.save(p);
        System.out.println(p);
    }


    @Test
    public void testDeleteCategorie() {
        categorieRepository.deleteById(5L);

    }



}