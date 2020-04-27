package mymoneymanager.backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mymoneymanager.backend.api.ImportService;
import mymoneymanager.backend.model.FinanceImport;

@RestController
public class FinanceImportController {
	private static final Logger LOG = LoggerFactory.getLogger(FinanceImportController.class);	
	
	@Autowired
	ImportService service;
	
	
    @PostMapping("/import")
	public HttpStatus importFinances(@RequestBody FinanceImport importedData) {
    	LOG.info("Importing finances with data...{}", importedData);
    	service.saveFinances(importedData);
		return HttpStatus.OK;
	}
	


}
