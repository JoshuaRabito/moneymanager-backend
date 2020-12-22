package mymoneymanager.backend.repository;

import java.util.Date;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mymoneymanager.backend.model.AccountEntity;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
  
  
  public Optional<AccountEntity> findByAccountNameOrDateCreated(String name, Date dateCreated);

 

}
