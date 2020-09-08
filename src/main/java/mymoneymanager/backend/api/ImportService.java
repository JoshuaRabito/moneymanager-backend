package mymoneymanager.backend.api;

import mymoneymanager.backend.model.FinanceDTO;

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


}
