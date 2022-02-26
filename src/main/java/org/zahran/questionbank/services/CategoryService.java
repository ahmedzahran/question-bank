package org.zahran.questionbank.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.zahran.questionbank.ConstrainDeleteException;
import org.zahran.questionbank.entities.Category;
import org.zahran.questionbank.repositories.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {


    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories(){

        return (List<Category>) categoryRepository.findAll();
    }

    public Category findCategoryById(Long id){
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElseThrow(() -> new RuntimeException("Category Not Found"));
    }

    public void saveCategory(Category category){
        categoryRepository.save(category);
    }

    public void deleteCategory(Long id){
        Category cat = findCategoryById(id);
        if (cat.getQuestions().isEmpty()){
            categoryRepository.deleteById(id);
            return;
        }
        throw new ConstrainDeleteException("cant delete category have questions");
    }

    public Page<Category> listAll(Pageable pageable, Optional<String> name) {

        if (name.isPresent()){
            return categoryRepository.findByNameContaining(name.get(),pageable);
        }
        return categoryRepository.findAll(pageable);
    }



}
