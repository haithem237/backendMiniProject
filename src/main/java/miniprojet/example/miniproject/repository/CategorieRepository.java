package miniprojet.example.miniproject.repository;

import miniprojet.example.miniproject.entity.CategorieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<CategorieEntity, Long>  {
}
