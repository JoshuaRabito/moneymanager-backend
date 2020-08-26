package mymoneymanager.backend.api;

import mymoneymanager.backend.model.AccountDTO;
import mymoneymanager.backend.model.FinanceDTO;
import mymoneymanager.backend.model.FinanceSearchDTO;

/**
 * {@code ImportService} class
 * 
 * <br>
 * Interface for saving imported finances.
 * 
 * </br>
 * 
 * @author Rabito, Joshua
 *
 */
public interface ImportService {


  void saveFinances(FinanceDTO importedData);

  AccountDTO findFinances(FinanceSearchDTO param);

}
