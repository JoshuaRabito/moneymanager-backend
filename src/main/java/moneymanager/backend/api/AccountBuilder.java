package moneymanager.backend.api;

import moneymanager.backend.model.AccountEntity;

public interface AccountBuilder {

  AccountEntity buildAccountEntity(AccountDTO accountDTO);

  AccountDTO buildDTO(AccountEntity entity);

  AccountEntity updateExisting(AccountEntity existingAccount, AccountEntity updatedAccount);

}
