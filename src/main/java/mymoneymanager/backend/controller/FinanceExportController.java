package mymoneymanager.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import mymoneymanager.backend.api.ImportService;
import mymoneymanager.backend.model.AccountDTO;
import mymoneymanager.backend.model.FinanceSearchDTO;

@RestController
public class FinanceExportController {
  
  
  @Autowired
  ImportService service; 
  
  @GetMapping("/export")
  public AccountDTO exportFinances(FinanceSearchDTO param) {
    return service.findFinances(param);
    
  }

}
