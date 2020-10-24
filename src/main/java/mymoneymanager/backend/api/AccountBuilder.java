package mymoneymanager.backend.api;

import mymoneymanager.backend.model.AccountDTO;
import mymoneymanager.backend.model.AccountEntity;

public interface AccountBuilder {

  	AccountEntity buildAccountEntity(AccountDTO accountDTO);
  
    AccountDTO buildDTO(AccountEntity entity);

    AccountEntity updateExisting(AccountEntity existingAccount, AccountEntity updatedAccount);

}
