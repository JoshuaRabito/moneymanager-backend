package mymoneymanager.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mymoneymanager.backend.api.AccountBuilder;
import mymoneymanager.backend.api.UserLookup;
import mymoneymanager.backend.model.AccountDto;
import mymoneymanager.backend.model.AccountEntity;
import mymoneymanager.backend.model.FinanceImport;

@Service
public class AccountBuilderImpl implements AccountBuilder {
 
  private UserLookup userLookup;
  
  
  @Autowired
  public AccountBuilderImpl(UserLookup userLookup) {
    this.userLookup = userLookup;
  }



  @Override
  public AccountEntity buildAccountEntity(FinanceImport importedData) {
    AccountEntity accountDto = new AccountEntity();
    accountDto.setAccountName(importedData.getAccountName());
    accountDto.setAccountType(importedData.getAccountType());
//    accountDto.setDeductions(importedData.getDeductions());
    accountDto.setGrossAmount(importedData.getGrossIncome());
    accountDto.setNetAmount(importedData.getNetIncome());
//    accountDto.setUser();


    return accountDto;
  }

}
