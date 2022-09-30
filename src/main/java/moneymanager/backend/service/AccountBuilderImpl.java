package moneymanager.backend.service;

import java.util.Date;
import moneymanager.backend.api.AccountBuilder;
import moneymanager.backend.api.DeductionBuilder;
import moneymanager.backend.api.UserBuilder;
import moneymanager.backend.api.AccountDTO;
import moneymanager.backend.model.AccountEntity;
import moneymanager.backend.model.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountBuilderImpl implements AccountBuilder {

  private UserService userLookup;
  private DeductionBuilder deductionBuilder;
  private UserBuilder userBuilder;


  @Autowired
  public AccountBuilderImpl(UserService userLookup, DeductionBuilder deductionBuilder,
      UserBuilder userBuilder) {
    this.userLookup = userLookup;
    this.deductionBuilder = deductionBuilder;
    this.userBuilder = userBuilder;
  }


  @Override
  public AccountEntity buildAccountEntity(AccountDTO importedData) {
    AccountEntity accountEntity = new AccountEntity();
    accountEntity.setAccountTypeId(AccountType.getId(importedData.getAccountType()));
    accountEntity.setDeductions(deductionBuilder.buildDeductions(importedData.getDeductions()));
    accountEntity.setGrossAmount(importedData.getGrossAmount());
    accountEntity.setNetAmount(importedData.getNetAmount());
    accountEntity.setAccountName(importedData.getAccountName());
    accountEntity
        .setUser(userLookup.getUser(importedData.getUser()));
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
    dto.setUser(userBuilder.build(entity.getUser()));
    return dto;
  }


  @Override
  public AccountEntity updateExisting(AccountEntity existingAccount, AccountEntity updatedAccount) {
    existingAccount.setAccountName(updatedAccount.getAccountName());
    existingAccount.setAccountTypeId(updatedAccount.getAccountTypeId());
    existingAccount.setDateUpdated(new Date());
    existingAccount.setDeductions(updatedAccount.getDeductions());
    existingAccount.setGrossAmount(updatedAccount.getGrossAmount());
    existingAccount.setNetAmount(updatedAccount.getNetAmount());
    return existingAccount;
  }

}
