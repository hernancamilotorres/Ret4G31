package com.g31.jpa.service;

import com.g31.jpa.entity.Category;
import com.g31.jpa.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Camilo Torres C
 */

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getCategory(){
        return categoryRepository.findAll();
    }
    
    public Category getCategoryById(Long idCat){
        return categoryRepository.findById(idCat).get();
    }
    
    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }
    
    //Metodo para eliminar (Capa de servicios)
    public void deleteCategory(Long id){
       categoryRepository.deleteById(id);               
    }
    
    public Category updateCategory(Category category){
        if (category.getId()!=null){
            //Solo funciona si el id esta en la base de datos a consultar
            Optional<Category> opcional = categoryRepository.findById(category.getId());
            
            if (!opcional.isEmpty()){
                //logica
                Category categoryBD = opcional.get();
                
                categoryBD.setName(category.getName());
                categoryBD.setDescription(category.getDescription());
                return categoryRepository.save(categoryBD);
            }else{
                return category;
            }
        }
        return category;       
    }
}
