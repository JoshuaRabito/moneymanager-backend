package mymoneymanager.backend.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mymoneymanager.backend.api.AccountBuilder;
import mymoneymanager.backend.api.ImportService;
import mymoneymanager.backend.model.AccountDTO;
import mymoneymanager.backend.model.AccountEntity;
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
  public void saveFinances(AccountDTO accountDTO) {
    AccountEntity account = accountBuilder.buildAccountEntity(accountDTO);
    Optional<AccountEntity> persistedAccount =
        accountRepo.findByAccountNameOrDateCreated(accountDTO.getAccountName(), accountDTO.getDateCreated());
    if (persistedAccount.isPresent()) {
      account = updateExistingAccount(account, persistedAccount.get());
    }
    accountRepo.save(account);
  }



  private AccountEntity updateExistingAccount(AccountEntity account,
      AccountEntity persistedAccount) {
    accountBuilder.updateExisting(persistedAccount, account);
    account = persistedAccount;
    return account;
  }



}
