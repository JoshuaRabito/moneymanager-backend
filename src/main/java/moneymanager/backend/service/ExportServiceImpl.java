package moneymanager.backend.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import moneymanager.backend.api.AccountBuilder;
import moneymanager.backend.api.DeductionBuilder;
import moneymanager.backend.api.ExportService;
import moneymanager.backend.api.AccountDTO;
import moneymanager.backend.model.AccountEntity;
import moneymanager.backend.api.DeductionDTO;
import moneymanager.backend.model.DeductionEntity;
import moneymanager.backend.model.DeductionTypes;
import moneymanager.backend.repository.AccountRepository;
import moneymanager.backend.repository.DeductionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
