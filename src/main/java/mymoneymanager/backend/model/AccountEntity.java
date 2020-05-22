package mymoneymanager.backend.model;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name="accounts")
public class AccountEntity {

  @Id
  @Column(name="account_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long accountId;
  private String accountType;
  private String accountName;
  private List<DeductionEntity> deductions;
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

  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(
          name = "account_deduction_xref",
          joinColumns = { @JoinColumn(name = "account_id") },
          inverseJoinColumns = { @JoinColumn(name = "account_id") })
  public List<DeductionEntity> getDeductions() {
    return deductions;
  }

  public void setDeductions(List<DeductionEntity> deductions) {
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
