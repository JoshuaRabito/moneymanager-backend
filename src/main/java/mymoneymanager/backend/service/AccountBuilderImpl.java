package mymoneymanager.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import mymoneymanager.backend.api.AccountBuilder;
import mymoneymanager.backend.api.UserLookup;
import mymoneymanager.backend.model.AccountDto;
import mymoneymanager.backend.model.FinanceImport;

public class AccountBuilderImpl implements AccountBuilder {

  @Autowired
  private UserLookup userLookup;

  @Override
  public AccountDto buildAccount(FinanceImport importedData) {
    AccountDto accountDto = new AccountDto();
    accountDto.setAccountType(importedData.getAccountType());
    accountDto.setAccountName(importedData.getAccountName());
    accountDto.setDeductions(importedData.getDeductions());
    accountDto
        .setUser(userLookup.lookupUser(importedData.getFirstName(), importedData.getLastName()));
    accountDto.setGrossAmount(importedData.getGrossIncome());
    accountDto.setNetAmount(importedData.getNetIncome());

    return accountDto;
  }

}
