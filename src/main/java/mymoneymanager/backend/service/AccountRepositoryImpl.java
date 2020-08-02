package mymoneymanager.backend.service;

import java.util.Date;
import java.util.Optional;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mymoneymanager.backend.model.AccountEntity;
import mymoneymanager.backend.repository.AccountRepository;

@Service
@Transactional
public class AccountRepositoryImpl implements AccountRepository {

  @PersistenceContext
  private EntityManager entityManager;
  
  @Autowired
  private Logger logger;

  @Override
  public <S extends AccountEntity> S save(S entity) {
    entityManager.persist(entity);
    return entity;
  }

  @Override
  public <S extends AccountEntity> Iterable<S> saveAll(Iterable<S> entities) {
    for (S s : entities) {
      entityManager.persist(s);
    }
    return entities;
  }

  @Override
  public Optional<AccountEntity> findById(Long id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean existsById(Long id) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Iterable<AccountEntity> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Iterable<AccountEntity> findAllById(Iterable<Long> ids) {
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
  public void delete(AccountEntity entity) {
    // TODO Auto-generated method stub

  }

  @Override
  public void deleteAll(Iterable<? extends AccountEntity> entities) {
    // TODO Auto-generated method stub

  }

  @Override
  public void deleteAll() {
    // TODO Auto-generated method stub

  }

  @Override
  public Optional<AccountEntity> findByNameOrDateCreated(String name, Date dateCreated) {
    System.out.println("getting account by ");
    return entityManager.createNamedQuery("AccountEntity.findByNameOrDate", AccountEntity.class)
        .setParameter(1, name).setParameter(2, dateCreated).getResultStream().findFirst();
  }



}
