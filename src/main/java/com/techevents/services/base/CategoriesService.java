package com.techevents.services.base;

import com.techevents.entities.Category;
import com.techevents.exceptions.entity.InvalidCategoryException;

import java.io.InvalidObjectException;
import java.util.List;
import java.util.Locale;

public interface CategoriesService {

  List<Category> getAllCategories();

  Category getCategoryByName(String categoryName);

  void createCategory(Category category) throws InvalidCategoryException;
}
