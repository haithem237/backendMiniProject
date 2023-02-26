package miniprojet.example.miniproject.repository;

import miniprojet.example.miniproject.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long>  {
}
