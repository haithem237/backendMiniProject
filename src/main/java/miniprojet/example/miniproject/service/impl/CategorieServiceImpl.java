package miniprojet.example.miniproject.service.impl;

import miniprojet.example.miniproject.entity.CategorieEntity;
import miniprojet.example.miniproject.repository.CategorieRepository;
import miniprojet.example.miniproject.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CategorieServiceImpl implements CategorieService {

    private final CategorieRepository categorieRepository;
    @Autowired
    public CategorieServiceImpl(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }


    @Override
    public List<CategorieEntity> findAllCategorie()
    {
        return categorieRepository.findAll();
    }

    @Override
    public Optional<CategorieEntity> findById(Long id) {
        return categorieRepository.findById(id);
    }

    @Override
    public CategorieEntity saveCategorie(CategorieEntity categorieEntity) {
        return categorieRepository.save(categorieEntity);
    }

    @Override
    public CategorieEntity updateCategorie(CategorieEntity categorieEntity) {

        return categorieRepository.save(categorieEntity);
    }


    @Override
    public void deleteCategorie(Long id) {
        categorieRepository.deleteById(id);

    }

}
