package moneymanager.backend.api;

/**
 * {@code ImportService} class
 *
 * <br>
 * Interface for saving imported finances.
 *
 * </br>
 *
 * @author Rabito, Joshua
 */
public interface ImportService {


  void saveFinances(AccountDTO importedData);


}
