package com.techevents.repositories.base;

import com.techevents.entities.base.ModelEntity;
import org.springframework.context.annotation.Bean;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public interface GenericRepository<T extends ModelEntity> {
  List<T> getAll();

  T getById(int id);

  T create(T entity);

}
