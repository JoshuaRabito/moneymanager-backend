package mymoneymanager.backend.model;

import java.io.Serializable;
import java.util.Date;

public class FinanceSearchParam implements Serializable {
  private Date dateCreated;
  private Date dateUpdated;
  private String accountName;

  public Date getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }

  public Date getDateUpdated() {
    return dateUpdated;
  }

  public void setDateUpdated(Date dateUpdated) {
    this.dateUpdated = dateUpdated;
  }

  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }


  

}
