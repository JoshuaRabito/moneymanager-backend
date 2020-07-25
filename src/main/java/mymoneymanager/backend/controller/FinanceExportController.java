package mymoneymanager.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import mymoneymanager.backend.api.ImportService;
import mymoneymanager.backend.model.AccountDTO;
import mymoneymanager.backend.model.FinanceDTO;
import mymoneymanager.backend.model.FinanceSearchParam;

@RestController
public class FinanceExportController {
  
  
  @Autowired
  ImportService service; 
  
  @PostMapping("/export")
  public AccountDTO exportFinances(FinanceSearchParam param) {
    return service.findFinances(param);
    
  }

}
