package mymoneymanager.backend.api;

import java.util.Date;
import mymoneymanager.backend.model.AccountDTO;
import mymoneymanager.backend.model.DeductionDTO;

public interface ExportService {
  
  AccountDTO findFinances(String accountName, Date dateCreated);

  DeductionDTO findDeductionInSavings(String accountName);


}
