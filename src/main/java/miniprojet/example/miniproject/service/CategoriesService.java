package miniprojet.example.miniproject.service;

import miniprojet.example.miniproject.entity.Categories;
import miniprojet.example.miniproject.entity.Produit;
import miniprojet.example.miniproject.repository.CategoriesRepository;
import miniprojet.example.miniproject.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class CategoriesService {


    CategoriesRepository categoriesRepository;
    @Autowired
    ProduitRepository produitRepository;

    List<Produit> produit;
    @Autowired
    public CategoriesService(CategoriesRepository categoryRepository){
        this.categoriesRepository = categoryRepository;
    }

    public List<Categories> getAllListCategories(){
        return categoriesRepository.findAll();
    }

    public List<Produit> getAllListProdCat(Long id){

        produit = produitRepository.findAll();
        List<Produit> produit1 = new ArrayList<>();
        for (Produit prod : produit) {

            if (prod.getCategories().getId() == id) {
                produit1.add(prod);
            }
        }
        return produit1;
    }
    public Categories findById (Long id){
        return categoriesRepository.findById(id).orElseThrow(()-> new RuntimeException("entity not found"));
    }


    public Categories create (Categories categories){

        LocalDate date = LocalDate.now();
        categories.setDateCreation(date);
        categories.setDateModif(date);

        return categoriesRepository.save(categories);
    }


    public Categories update (Categories categories){

        LocalDate date = LocalDate.now();
        categories.setDateModif(date);
        return categoriesRepository.saveAndFlush(categories);
    }

    public boolean delete(long id){
        Categories categories = categoriesRepository.findById(id).orElseThrow(()-> new RuntimeException("entity not found"));
        categoriesRepository.delete(categories);
        return  true;
    }




}
