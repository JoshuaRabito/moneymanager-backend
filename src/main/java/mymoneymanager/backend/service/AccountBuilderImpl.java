package mymoneymanager.backend.service;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mymoneymanager.backend.api.AccountBuilder;
import mymoneymanager.backend.api.DeductionBuilder;
import mymoneymanager.backend.api.UserLookup;
import mymoneymanager.backend.model.AccountDTO;
import mymoneymanager.backend.model.AccountEntity;
import mymoneymanager.backend.model.AccountType;
import mymoneymanager.backend.model.FinanceDTO;

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
  public AccountEntity buildAccountEntity(FinanceDTO importedData) {
    AccountEntity accountEntity = new AccountEntity();
    accountEntity.setAccountTypeId(importedData.getAccountType().getId());
    accountEntity.setDeductions(deductionBuilder.buildDeductions(importedData.getDeductions()));
    accountEntity.setGrossAmount(importedData.getGrossIncome());
    accountEntity.setNetAmount(importedData.getNetIncome());
    accountEntity.setAccountName(importedData.getAccountName());
    accountEntity
        .setUser(userLookup.getUserEntity(importedData.getFirstName(), importedData.getLastName()));
    accountEntity.setDateCreated(new Date());


    return accountEntity;
  }



  @Override
  public AccountDTO buildDTO(AccountEntity entity) {
    AccountDTO dto = new AccountDTO();
    dto.setAccountName(entity.getAccountName());
    dto.setAccountType(AccountType.getType(entity.getAccountTypeId()));
    dto.setDateCreated(entity.getDateCreated());
    dto.setDateUpdated(entity.getDateUpdated());
    dto.setDeductions(deductionBuilder.buildDeductionsDTOs(entity.getDeductions()));
    dto.setGrossAmount(entity.getGrossAmount());
    dto.setNetAmount(entity.getNetAmount());
    dto.setUser(entity.getUser());
    return dto;
  }

}
