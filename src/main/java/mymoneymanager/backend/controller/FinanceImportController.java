package mymoneymanager.backend.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import mymoneymanager.backend.api.ImportService;
import mymoneymanager.backend.model.FinanceDTO;

@RestController
public class FinanceImportController {

  @Autowired
  private ImportService service;

  @Autowired
  private Logger logger;


  @PostMapping("/import")
  public HttpStatus importFinances(@RequestBody FinanceDTO importedData) {
    logger.log(Level.INFO,"Importing finances with data...{0}", importedData);
    try {
      service.saveFinances(importedData);
      return HttpStatus.OK;
    } catch (Exception ex) {
      logger.log(Level.SEVERE,"An exception occurred processing data", ex);
      return HttpStatus.INTERNAL_SERVER_ERROR;
    }


  }

}
