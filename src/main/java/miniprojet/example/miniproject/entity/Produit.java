package miniprojet.example.miniproject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name="mt_produits")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Qt")
    private long qt;
    @Column(name = "Disponible")
    private boolean disponible;
    @Column(name = "Date_creation")
    private LocalDate dateCreation;
    @Column(name = "Date_modif")
    private LocalDate dateModif;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "categoriesId")
    Categories categories;
    @Column(insertable=false, updatable=false)
    private Long categoriesId;



}
