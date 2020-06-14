package mymoneymanager.backend.repository;

import org.springframework.data.repository.CrudRepository;
import mymoneymanager.backend.model.AccountDto;
import mymoneymanager.backend.model.AccountEntity;

public interface AccountRepository extends CrudRepository<AccountEntity, Long> {

 

}
