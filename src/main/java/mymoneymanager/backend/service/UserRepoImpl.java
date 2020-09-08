package mymoneymanager.backend.service;

import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Service;
import mymoneymanager.backend.model.UserEntity;
import mymoneymanager.backend.model.UserEntity_;
import mymoneymanager.backend.repository.UserRepository;

@Service
public class UserRepoImpl implements UserRepository{
  
  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public <S extends UserEntity> S save(S entity) {
    entityManager.persist(entity);
    return entity;
  }

  @Override
  public <S extends UserEntity> Iterable<S> saveAll(Iterable<S> entities) {
    for (S s : entities) {
      entityManager.persist(s);
    }
    return entities;
  }

  @Override
  public Optional<UserEntity> findById(Long id) {
    Optional<UserEntity> userEntity = Optional.ofNullable(entityManager.find(UserEntity.class, id));
    return userEntity;
  }

  @Override
  public boolean existsById(Long id) {
    UserEntity userEntity = entityManager.find(UserEntity.class, id);
    return userEntity != null;
  }

  @Override
  public Iterable<UserEntity> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Iterable<UserEntity> findAllById(Iterable<Long> ids) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public long count() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void deleteById(Long id) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void delete(UserEntity entity) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void deleteAll(Iterable<? extends UserEntity> entities) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void deleteAll() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public UserEntity findByName(String lastName, String firstName) {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<UserEntity> criteriaQuery = cb.createQuery(UserEntity.class);
     
    Root<UserEntity> root = criteriaQuery.from(UserEntity.class);
    criteriaQuery.select(root).where(cb.equal(root.get(UserEntity_.lastName), lastName));
     
    TypedQuery<UserEntity> query = entityManager.createQuery(criteriaQuery);
    query.setMaxResults(1);
    return query.getSingleResult();
  }

  @Override
  public UserEntity findById(long id) {
    // TODO Auto-generated method stub
    return null;
  }

}
