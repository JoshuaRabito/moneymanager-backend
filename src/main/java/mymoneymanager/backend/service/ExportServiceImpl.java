package mymoneymanager.backend.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mymoneymanager.backend.api.AccountBuilder;
import mymoneymanager.backend.api.DeductionBuilder;
import mymoneymanager.backend.api.ExportService;
import mymoneymanager.backend.model.AccountDTO;
import mymoneymanager.backend.model.AccountEntity;
import mymoneymanager.backend.model.DeductionDTO;
import mymoneymanager.backend.model.DeductionEntity;
import mymoneymanager.backend.model.DeductionTypes;
import mymoneymanager.backend.repository.AccountRepository;
import mymoneymanager.backend.repository.DeductionRepository;

@Service
public class ExportServiceImpl implements ExportService {

  private AccountBuilder accountBuilder;
  private AccountRepository accountRepo;
  private DeductionRepository deductionRepo;
  private DeductionBuilder deductionBuilder;


  @Autowired
  public ExportServiceImpl(AccountBuilder accountBuilder, AccountRepository accountRepo,
      DeductionRepository deductionRepo, DeductionBuilder deductionBuilder) {
    this.accountBuilder = accountBuilder;
    this.accountRepo = accountRepo;
    this.deductionRepo = deductionRepo;
    this.deductionBuilder = deductionBuilder;
  }

  @Override
  public AccountDTO findFinances(String accountName, Date dateCreated) {
    AccountDTO dto = null;
    Optional<AccountEntity> accountEntity =
        accountRepo.findByAccountNameOrDateCreated(accountName, dateCreated);
    if (accountEntity.isPresent()) {
      dto = accountBuilder.buildDTO(accountEntity.get());
    }
    return dto;
  }

  @Override
  public DeductionDTO findDeductionInSavings(String deductionName) {
    List<DeductionEntity> deductionEntities = deductionRepo
        .findByNameContaining(deductionName, DeductionTypes.SAVINGS.getId());
   return deductionBuilder.buildSumDeduction(deductionEntities);
  }

}
