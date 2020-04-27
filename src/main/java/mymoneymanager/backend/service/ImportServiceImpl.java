package mymoneymanager.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mymoneymanager.backend.api.AccountBuilder;
import mymoneymanager.backend.api.ImportService;
import mymoneymanager.backend.model.AccountDto;
import mymoneymanager.backend.model.FinanceImport;

@Service
public class ImportServiceImpl implements ImportService {
	
	@Autowired
	private AccountBuilder accountBuilder;
	
	
	

	@Override
	public void saveFinances(FinanceImport importedData) {
		AccountDto accountDto = accountBuilder.buildAccount(importedData);
		
	}



}
