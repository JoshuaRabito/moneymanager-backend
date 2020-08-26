package mymoneymanager.backend.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mymoneymanager.backend.api.AccountBuilder;
import mymoneymanager.backend.api.ImportService;
import mymoneymanager.backend.model.AccountDTO;
import mymoneymanager.backend.model.AccountEntity;
import mymoneymanager.backend.model.FinanceDTO;
import mymoneymanager.backend.model.FinanceSearchDTO;
import mymoneymanager.backend.repository.AccountRepository;

@Service
public class ImportServiceImpl implements ImportService {

  private AccountBuilder accountBuilder;
  private AccountRepository accountRepo;


  @Autowired
  public ImportServiceImpl(AccountBuilder accountBuilder, AccountRepository accountRepo) {
    this.accountBuilder = accountBuilder;
    this.accountRepo = accountRepo;
  }



  @Override
  public void saveFinances(FinanceDTO importedData) {
    AccountEntity account = accountBuilder.buildAccountEntity(importedData);
    accountRepo.save(account);
  }



  @Override
  public AccountDTO findFinances(FinanceSearchDTO param) {
    Optional<AccountEntity> accountEntity =
        accountRepo.findByNameOrDateCreated(param.getAccountName(), param.getDateCreated());
    if(accountEntity.isPresent()) {
      accountBuilder.buildDTO(accountEntity);
    }
    return null;
  }



}
