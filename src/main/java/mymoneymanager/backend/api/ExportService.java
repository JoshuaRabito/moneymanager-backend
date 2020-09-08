package mymoneymanager.backend.api;

import java.util.Date;
import mymoneymanager.backend.model.AccountDTO;

public interface ExportService {
  
  AccountDTO findFinances(String accountName, Date dateCreated);


}
