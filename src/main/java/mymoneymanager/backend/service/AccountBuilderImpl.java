package mymoneymanager.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mymoneymanager.backend.api.AccountBuilder;
import mymoneymanager.backend.api.DeductionBuilder;
import mymoneymanager.backend.api.UserBuilder;
import mymoneymanager.backend.api.UserLookup;
import mymoneymanager.backend.model.AccountDto;
import mymoneymanager.backend.model.AccountEntity;
import mymoneymanager.backend.model.FinanceImport;

@Service
public class AccountBuilderImpl implements AccountBuilder {
 
  private UserLookup userLookup;
  private DeductionBuilder deductionBuilder;
  
  
  @Autowired
  public AccountBuilderImpl(UserLookup userLookup, DeductionBuilder deductionBuilder) {
    this.userLookup = userLookup;
    this.deductionBuilder = deductionBuilder;
  }



  @Override
  public AccountEntity buildAccountEntity(FinanceImport importedData) {
    AccountEntity accountEntity = new AccountEntity();
    accountEntity.setAccountTypeId(importedData.getAccountType().getId());
    accountEntity.setDeductions(deductionBuilder.buildDeductions(importedData.getDeductions()));
    accountEntity.setGrossAmount(importedData.getGrossIncome());
    accountEntity.setNetAmount(importedData.getNetIncome());
    accountEntity.setAccountName(importedData.getAccountName());
    accountEntity.setUser(userLookup.getUserEntity(importedData.getFirstName(), importedData.getLastName()));


    return accountEntity;
  }

}
