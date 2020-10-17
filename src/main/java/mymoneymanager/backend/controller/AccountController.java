package mymoneymanager.backend.controller;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import mymoneymanager.backend.api.ExportService;
import mymoneymanager.backend.api.ImportService;
import mymoneymanager.backend.model.AccountDTO;

@RestController
public class AccountController {


  @Autowired
  private ExportService exportService;

  @Autowired
  private ImportService importService;

  @Autowired
  private Logger logger;

  @GetMapping("/accounts")
  @ResponseBody
  public ResponseEntity<AccountDTO> exportFinances(
      @RequestParam(name = "accountName") String accountName,
      @RequestParam(name = "dateCreated") Date dateCreated) {
    ResponseEntity<AccountDTO> response = ResponseEntity.noContent().build();
    try {
      logger.log(Level.INFO, "Looking up finances with accouunt name {0} and date {1} ...",
          new Object[] {accountName, dateCreated});

      AccountDTO account = exportService.findFinances(accountName, dateCreated);
      response = account != null ? ResponseEntity.ok(account) : ResponseEntity.notFound().build();

    } catch (Exception ex) {
      logger.log(Level.SEVERE,
          "An error occurred looking up finances by account name %s and date %tD", ex);
      response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
    return response;
  }


  @PostMapping("/accounts")
  public ResponseEntity<AccountDTO> importFinances(@RequestBody AccountDTO importedData) {
    logger.log(Level.INFO, "Importing finances with data...{0}", importedData);
    ResponseEntity<AccountDTO> response = ResponseEntity.noContent().build();

    try {
      importService.saveFinances(importedData);
      response = ResponseEntity.ok(importedData);
    } catch (Exception ex) {
      logger.log(Level.SEVERE, "An exception occurred processing data", ex);
      response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
    return response;
  }

}
