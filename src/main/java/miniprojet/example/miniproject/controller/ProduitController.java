package miniprojet.example.miniproject.controller;

import miniprojet.example.miniproject.entity.ProduitEntity;
import miniprojet.example.miniproject.service.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produit")
@CrossOrigin(origins = "http://localhost:4200/")
public class ProduitController {

    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }


    @GetMapping("/getAllProduct")
    @ResponseBody
    public List<ProduitEntity> finAllProduct()
    {
        return produitService.findAllProduit();
    }


    @GetMapping("/findProduitById/{id}")
    @ResponseBody
    public Optional<ProduitEntity> findProductById(@PathVariable("id")Long id)
    {
        return produitService.findById(id);

    }

    @PostMapping("/{id}")
    public ProduitEntity saveProduct(@RequestBody ProduitEntity produitEntity,@PathVariable Long id){


        return produitService.saveProduit(produitEntity,id); }


    @PutMapping ("/updateProduct/{id}")
    @ResponseBody
    public ProduitEntity updateProduct(@RequestBody ProduitEntity produitEntity ){

        LocalDate date =LocalDate.now();
        produitEntity.setDateDeModification(date);
        return produitService.updateProduit(produitEntity);
    }

    @DeleteMapping("delete/{id}")
    public void deleteProduct (@PathVariable("id") Long id)
    {
        produitService.deleteProduit(id);
    }




}
