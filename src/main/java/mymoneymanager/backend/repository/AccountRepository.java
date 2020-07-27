package mymoneymanager.backend.repository;

import java.util.Date;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import mymoneymanager.backend.model.AccountEntity;

public interface AccountRepository extends CrudRepository<AccountEntity, Long> {
  
  
  public Optional<AccountEntity> findByNameOrDateCreated(String name, Date dateCreated);

 

}
