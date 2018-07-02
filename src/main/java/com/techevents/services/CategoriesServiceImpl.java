package com.techevents.services;

import com.techevents.entities.Category;
import com.techevents.entities.Event;
import com.techevents.exceptions.entity.InvalidCategoryException;
import com.techevents.exceptions.entity.InvalidEventException;
import com.techevents.repositories.base.GenericRepository;
import com.techevents.services.base.CategoriesService;
import com.techevents.validation.base.Validator;
import org.springframework.stereotype.Service;

import java.io.InvalidObjectException;
import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService {

  private final GenericRepository<Category> categoriesRepository;
  private final Validator<Category> categoryValidator;


  public CategoriesServiceImpl(GenericRepository<Category> categoriesRepository, Validator<Category> categoryValidator) {
    this.categoriesRepository = categoriesRepository;
    this.categoryValidator = categoryValidator;
  }

  @Override
  public List<Category> getAllCategories() {
    return categoriesRepository.getAll();
  }

  @Override
  public Category getCategoryByName(String categoryName) {
    List<Category> categories = categoriesRepository.getAll();
    return categories.stream()
      .filter(category -> category.getName().equals(categoryName))
      .findFirst()
      .orElse(null);
  }

  @Override
  public void createCategory(Category category) throws InvalidCategoryException {
    if (!categoryValidator.isValid(category)){
      throw new InvalidCategoryException("Invalid data for fields of category: " + category);
    }
    categoriesRepository.create(category);

  }
}
