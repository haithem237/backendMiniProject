package miniprojet.example.miniproject.controller;

import miniprojet.example.miniproject.entity.Produit;
import miniprojet.example.miniproject.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produit")
@CrossOrigin(origins = "http://localhost:4200/")
public class ProduitController {

    private final ProduitService produitService;

    @Autowired
    public ProduitController(ProduitService produitService) {
        this.produitService= produitService;
    }
    @GetMapping(path = "/getProduit")
    public List<Produit> getAllConsumers(){
        return produitService.getAllListProduit();
    }
    @GetMapping("/{id}")
    public Produit findProduitById(@PathVariable("id") Long id) {
        return produitService.findById(id);
    }
    @PostMapping("/saveProduit/{id}")
    public Produit save(@RequestBody  Produit produit ,@PathVariable long id){
        return produitService.create(produit , id);
    }
    @PutMapping("/updateProduit/{id}")
    public Produit updateProduit(@RequestBody Produit produit , @PathVariable long id) {
        return produitService.update(produit , id);
    }
    @DeleteMapping("/delete{id}")
    public void deleteProduit(@PathVariable("id") Long id) {
        produitService.delete(id);
    }


}
