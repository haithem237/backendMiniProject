package miniprojet.example.miniproject;

import miniprojet.example.miniproject.entity.Categories;
import miniprojet.example.miniproject.service.CategoriesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class MiniProjectApplicationTests {
    @Autowired
    private   CategoriesService catServ;
    @Test
    void contextLoads() {
        Categories expectedCategorie = Categories.builder()
                .name("name cat")
                .qt(1)
                .build();
        Categories savedCategorie = catServ.create(expectedCategorie);
        assertNotNull(savedCategorie);
        assertNotNull(expectedCategorie.getName() , savedCategorie.getName());
    }

}
