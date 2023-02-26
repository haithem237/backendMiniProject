package miniprojet.example.miniproject.controller;




import miniprojet.example.miniproject.entity.Categories;
import miniprojet.example.miniproject.entity.Produit;
import miniprojet.example.miniproject.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/categorie")
@CrossOrigin(origins = "http://localhost:4200/")
public class CategoriesController {

    private CategoriesService categoriesService;
    @Autowired
    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }
    @GetMapping(path = "/getCategories")
    public List<Categories> getAllConsumers(){
        return categoriesService.getAllListCategories();
    }
    @GetMapping(path = "/getProdCat/{id}")
    public List<Produit> getAllConsumers(@PathVariable("id") Long id){
        return categoriesService.getAllListProdCat(id);
    }
    @GetMapping("/{id}")
    public Categories findCategoriesById(@PathVariable("id") Long id) {
        return categoriesService.findById(id);
    }
    @PostMapping("/saveCategories")
    public Categories save(@RequestBody Categories categories){
        return categoriesService.create(categories);
    }
    @PutMapping("/updateCategorie{id}")
    public Categories updateCategories(@RequestBody Categories categories) {
        return categoriesService.update(categories);
    }
    @DeleteMapping("/delete{id}")
    public void deleteCategories(@PathVariable("id") Long id) {
        categoriesService.delete(id);
    }




}
