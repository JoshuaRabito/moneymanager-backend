package mymoneymanager.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mymoneymanager.backend.api.AccountBuilder;
import mymoneymanager.backend.api.ImportService;
import mymoneymanager.backend.model.AccountDto;
import mymoneymanager.backend.model.AccountEntity;
import mymoneymanager.backend.model.FinanceImport;
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
  public void saveFinances(FinanceImport importedData) {
    AccountEntity account = accountBuilder.buildAccountEntity(importedData);
    accountRepo.save(account);
  }



}
