package miniprojet.example.miniproject.controller;




import miniprojet.example.miniproject.entity.CategorieEntity;
import miniprojet.example.miniproject.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/categorie")
@CrossOrigin(origins = "http://localhost:4200/")
public class CategorieController {


    private final CategorieService categorieService;
    @Autowired
    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping("/getAllCategorie")
    @ResponseBody
    public List<CategorieEntity> finAllCategories()
    {

        return categorieService.findAllCategorie();
    }

    @GetMapping("findById/{id}")
    @ResponseBody
    public Optional<CategorieEntity> findCategoriesById(@PathVariable("id")Long id)
    {
        return categorieService.findById(id);

    }

    @PostMapping("/addCategorie")
    @ResponseBody
    public CategorieEntity saveCategories(@RequestBody CategorieEntity categorieEntity )
    {
        categorieEntity.setDateDeCreation(LocalDate.now());
        categorieEntity.setDateDeModification(LocalDate.now());
        return categorieService.saveCategorie(categorieEntity);
    }



    @PutMapping("/updateCategorie")
    @ResponseBody
    public CategorieEntity updateCategories(@RequestBody CategorieEntity categoriesEntity )
    {
        CategorieEntity categorie = findCategoriesById(categoriesEntity.getId()).orElseThrow(()->new RuntimeException());
        categoriesEntity.setDateDeCreation(categorie.getDateDeCreation());

        LocalDate date =LocalDate.now();
        categoriesEntity.setDateDeModification(date);

        return categorieService.updateCategorie(categoriesEntity);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deleteCategories (@PathVariable("id") Long id)
    {
        categorieService.deleteCategorie(id);

    }




}
