package mymoneymanager.backend.api;

import mymoneymanager.backend.model.AccountDTO;
import mymoneymanager.backend.model.AccountEntity;
import mymoneymanager.backend.model.FinanceDTO;

public interface AccountBuilder {

  	AccountEntity buildAccountEntity(FinanceDTO importedData);
  
    AccountDTO buildDTO(AccountEntity entity);

}
