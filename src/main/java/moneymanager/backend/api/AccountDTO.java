package moneymanager.backend.api;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import moneymanager.backend.api.DeductionDTO;
import moneymanager.backend.api.UserDto;

public class AccountDTO implements Serializable {

  private Long accountId;
  private String accountType;
  private String accountName;
  private List<DeductionDTO> deductions;
  private UserDto user;
  private BigDecimal grossAmount;
  private BigDecimal netAmount;
  private Date dateCreated;
  private Date dateUpdated;

  public Long getAccountId() {
    return accountId;
  }

  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }

  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public List<DeductionDTO> getDeductions() {
    return deductions;
  }

  public void setDeductions(List<DeductionDTO> deductions) {
    this.deductions = deductions;
  }

  public UserDto getUser() {
    return user;
  }

  public void setUser(UserDto user) {
    this.user = user;
  }

  public BigDecimal getGrossAmount() {
    return grossAmount;
  }

  public void setGrossAmount(BigDecimal grossAmount) {
    this.grossAmount = grossAmount;
  }

  public BigDecimal getNetAmount() {
    return netAmount;
  }

  public void setNetAmount(BigDecimal netAmount) {
    this.netAmount = netAmount;
  }

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


}
