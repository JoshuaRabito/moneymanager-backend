package mymoneymanager.backend.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import mymoneymanager.backend.model.AccountDto;
import mymoneymanager.backend.model.AccountEntity;
import mymoneymanager.backend.repository.AccountRepository;

@Service
public class AccountRepositoryImpl implements AccountRepository {

  @Override
  public <S extends AccountEntity> S save(S entity) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <S extends AccountEntity> Iterable<S> saveAll(Iterable<S> entities) {
    // TODO Auto-generated method stub
    return null;
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
  public void save(AccountDto accountDto) {
    // TODO Auto-generated method stub

  }

}
