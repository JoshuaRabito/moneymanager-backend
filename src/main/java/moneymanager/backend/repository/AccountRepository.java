package moneymanager.backend.repository;

import java.util.Date;
import java.util.Optional;
import moneymanager.backend.model.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {


  public Optional<AccountEntity> findByAccountNameOrDateCreated(String name, Date dateCreated);


}
