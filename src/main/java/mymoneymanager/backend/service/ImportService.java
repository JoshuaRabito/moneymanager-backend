package mymoneymanager.backend.service;

import mymoneymanager.backend.model.FinanceImport;

/**
 * {@code ImportService} class
 * 
 * <br>
 * Interface for saving imported finances.
 * 
 * </br>
 * @author Rabito, Joshua
 *
 */
public interface ImportService {

	
	void saveFinances(FinanceImport importedData);

}
