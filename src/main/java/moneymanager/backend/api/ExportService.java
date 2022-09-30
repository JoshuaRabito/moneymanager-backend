package moneymanager.backend.api;

import java.util.Date;

public interface ExportService {

  AccountDTO findFinances(String accountName, Date dateCreated);

  DeductionDTO findDeductionInSavings(String accountName);


}
