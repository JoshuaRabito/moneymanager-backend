package mymoneymanager.backend.model;

import java.math.BigDecimal;
import java.util.List;

public class AccountDto {

  private String accountType;
  private String accountName;
  private List<Deduction> deductions;
  private UserDto user;
  private BigDecimal grossAmount;
  private BigDecimal netAmount;

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

  public List<Deduction> getDeductions() {
    return deductions;
  }

  public void setDeductions(List<Deduction> deductions) {
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

 



}
