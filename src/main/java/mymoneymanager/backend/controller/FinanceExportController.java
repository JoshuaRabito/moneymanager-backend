package mymoneymanager.backend.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import mymoneymanager.backend.api.ExportService;
import mymoneymanager.backend.model.AccountDTO;

@RestController
public class FinanceExportController {


  @Autowired
  ExportService service;

  @GetMapping("/export")
  @ResponseBody
  public AccountDTO exportFinances(@RequestParam(name ="accountName") String accountName,
      @RequestParam(name ="dateCreated") Date dateCreated) {
    AccountDTO account = service.findFinances(accountName, dateCreated);
    HttpStatus status = HttpStatus.NOT_FOUND;
    if (account != null) {
      status = HttpStatus.OK;
    }
    return account;

  }

}
