package miniprojet.example.miniproject.repository;

import miniprojet.example.miniproject.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
