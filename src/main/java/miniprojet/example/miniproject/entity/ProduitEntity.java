package miniprojet.example.miniproject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name="mt_produits")
public class ProduitEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "qte")
    private int qte;
    @Column(name = "disponibilty")
    private Boolean disponible;

    @Column(name = "date_de_creation")
    private LocalDate dateDeCreation;


    @Column(name = "date_de_modification")
    private LocalDate dateDeModification;


    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "categorie_id")
    CategorieEntity categorie;

    @Column(insertable = false,updatable = false)
    private Long categorie_id;





}
