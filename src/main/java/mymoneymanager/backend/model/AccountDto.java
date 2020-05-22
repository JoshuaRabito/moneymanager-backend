package mymoneymanager.backend.model;

import java.math.BigDecimal;
import java.util.List;

public class AccountDto {

  private Long accountId;
  private String accountType;
  private String accountName;
  private List<Deduction> deductions;
  private UserEntity user;
  private BigDecimal grossAmount;
  private BigDecimal netAmount;

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

  public List<Deduction> getDeductions() {
    return deductions;
  }

  public void setDeductions(List<Deduction> deductions) {
    this.deductions = deductions;
  }

  public UserEntity getUser() {
    return user;
  }

  public void setUser(UserEntity user) {
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
