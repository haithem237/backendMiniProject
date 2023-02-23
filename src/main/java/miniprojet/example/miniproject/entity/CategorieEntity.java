package miniprojet.example.miniproject.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name="mt_categorie")
public class CategorieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
    private long id;

    @Column(name = "nom")
        private String nom;

    @Column(name = "qte")
    private int qte;

    @Column(name = "date_de_creation")
    private LocalDate dateDeCreation;

    @Column(name = "date_de_modification")
    private LocalDate dateDeModification;



    @OneToMany(fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<ProduitEntity> produits;



}
