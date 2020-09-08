package mymoneymanager.backend.service;

import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mymoneymanager.backend.api.AccountBuilder;
import mymoneymanager.backend.api.ExportService;
import mymoneymanager.backend.model.AccountDTO;
import mymoneymanager.backend.model.AccountEntity;
import mymoneymanager.backend.repository.AccountRepository;

@Service
public class ExportServiceImpl implements ExportService {

  private AccountBuilder accountBuilder;
  private AccountRepository accountRepo;


  @Autowired
  public ExportServiceImpl(AccountBuilder accountBuilder, AccountRepository accountRepo) {
    this.accountBuilder = accountBuilder;
    this.accountRepo = accountRepo;
  }

  @Override
  public AccountDTO findFinances(String accountName, Date dateCreated) {
    AccountDTO dto = null;
    Optional<AccountEntity> accountEntity = accountRepo.findByNameOrDateCreated(accountName, dateCreated);
    if(accountEntity.isPresent()) {
      dto = accountBuilder.buildDTO(accountEntity.get());
    }
    return dto;
  }

}
