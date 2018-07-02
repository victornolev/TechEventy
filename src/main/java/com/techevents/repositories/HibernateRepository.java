package com.techevents.repositories;

import com.techevents.entities.base.ModelEntity;
import com.techevents.repositories.base.GenericRepository;
import org.apache.lucene.queryparser.flexible.core.builders.QueryBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

public class HibernateRepository<T extends ModelEntity> implements GenericRepository<T> {
  private final SessionFactory sessionFactory;
  private Class<T> entityClass;

  public HibernateRepository(SessionFactory sessionFactory, Class<T> entityClass) {
    this.sessionFactory = sessionFactory;
    setEntityClass(entityClass);
  }

  @Override
  public List<T> getAll() {
    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();

    CriteriaBuilder builder = session.getCriteriaBuilder();

    CriteriaQuery<T> criteriaQuery = builder.createQuery(getEntityClass());
    criteriaQuery.from(getEntityClass());

    List<T> entities = session.createQuery(criteriaQuery)
      .getResultList();

    transaction.commit();
    session.close();

    return entities;
  }

  @Override
  public T getById(int id) {
    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();

    CriteriaBuilder builder = session.getCriteriaBuilder();

    CriteriaQuery<T> criteriaQuery = builder.createQuery(getEntityClass());

    T entity = session.get(getEntityClass(), id);

    transaction.commit();
    session.close();

    return entity;
  }

  @Override
  public T create(T entity) {
    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();

    session
      .save(entity);

    transaction.commit();
    session.close();
    return entity;
  }

  public Class<T> getEntityClass() {
    return entityClass;
  }

  public void setEntityClass(Class<T> entityClass) {
    this.entityClass = entityClass;
  }
}
