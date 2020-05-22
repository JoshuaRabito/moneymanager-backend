package mymoneymanager.backend.api;

import mymoneymanager.backend.model.AccountDto;
import mymoneymanager.backend.model.AccountEntity;
import mymoneymanager.backend.model.FinanceImport;

public interface AccountBuilder {

	AccountEntity buildAccountEntity(FinanceImport importedData);

}
