package mymoneymanager.backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import mymoneymanager.backend.api.ImportService;
import mymoneymanager.backend.model.FinanceDTO;

@RestController
public class FinanceImportController {
  private static final Logger LOG = LoggerFactory.getLogger(FinanceImportController.class);

  @Autowired
  ImportService service;


  @PostMapping("/import")
  public HttpStatus importFinances(@RequestBody FinanceDTO importedData) {
    LOG.info("Importing finances with data...{}", importedData);
    try {
      service.saveFinances(importedData);
      return HttpStatus.OK;
    } catch (Exception ex) {
       LOG.error("An exception occurred processing data", ex);
       return HttpStatus.INTERNAL_SERVER_ERROR;
    }


  }

}
