package mymoneymanager.backend.api;

import java.util.Optional;
import mymoneymanager.backend.model.AccountEntity;
import mymoneymanager.backend.model.FinanceDTO;

public interface AccountBuilder {

  	AccountEntity buildAccountEntity(FinanceDTO importedData);
  
    void buildDTO(Optional<AccountEntity> accountEntity);

}
