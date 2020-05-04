package mymoneymanager.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mymoneymanager.backend.api.AccountBuilder;
import mymoneymanager.backend.api.UserLookup;
import mymoneymanager.backend.model.AccountDto;
import mymoneymanager.backend.model.FinanceImport;

@Service
public class AccountBuilderImpl implements AccountBuilder {
 
  private UserLookup userLookup;
  
  
  @Autowired
  public AccountBuilderImpl(UserLookup userLookup) {
    this.userLookup = userLookup;
  }



  @Override
  public AccountDto buildAccount(FinanceImport importedData) {
    AccountDto accountDto = new AccountDto();
  

    return accountDto;
  }

}
