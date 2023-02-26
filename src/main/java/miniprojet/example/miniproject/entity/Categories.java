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
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "Qt")
    private long qt;
    @Column(name = "Date_creation")
    private LocalDate dateCreation;
    @Column(name = "Date_modif")
    private LocalDate dateModif;
    @JsonManagedReference
    @OneToMany(mappedBy = "categories", cascade = CascadeType.ALL)
    private List<Produit> produit ;


}
