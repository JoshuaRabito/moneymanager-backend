package moneymanager.backend.service;

import java.util.Optional;
import moneymanager.backend.api.AccountBuilder;
import moneymanager.backend.api.ImportService;
import moneymanager.backend.api.AccountDTO;
import moneymanager.backend.model.AccountEntity;
import moneymanager.backend.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        accountRepo
            .findByAccountNameOrDateCreated(account.getAccountName(), account.getDateCreated());
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
