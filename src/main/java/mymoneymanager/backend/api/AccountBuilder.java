package mymoneymanager.backend.api;

import mymoneymanager.backend.model.AccountDto;
import mymoneymanager.backend.model.FinanceImport;

public interface AccountBuilder {

	AccountDto buildAccount(FinanceImport importedData);

}
