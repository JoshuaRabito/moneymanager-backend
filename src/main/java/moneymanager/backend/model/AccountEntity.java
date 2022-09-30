package moneymanager.backend.model;

import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.validation.constraints.Digits;

@Entity(name = "accounts")
@NamedQuery(name = "AccountEntity.findByNameOrDate",
    query = "select a from accounts a where a.accountName = ?1 or " + "a.dateCreated = ?2")
public class AccountEntity {

  @Id
  @Column(name = "account_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long accountId;

  @Column(name = "account_type_id")
  private Integer accountTypeId;

  @Column(name = "account_name")
  private String accountName;

  @ManyToMany(cascade = {CascadeType.ALL})
  @JoinTable(name = "account_deduction_xref", joinColumns = {@JoinColumn(name = "account_id")},
      inverseJoinColumns = {@JoinColumn(name = "deduction_id")})
  private List<DeductionEntity> deductions;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private UserEntity user;

  @Column(name = "gross_amount", precision = 7, scale = 2)
  @Digits(integer = 5, fraction = 2)
  private BigDecimal grossAmount;

  @Column(name = "net_amount", precision = 7, scale = 2)
  @Digits(integer = 5, fraction = 2)
  private BigDecimal netAmount;

  @Column(name = "date_created")
  private Date dateCreated;

  @Column(name = "date_updated")
  private Date dateUpdated;

  public Long getAccountId() {
    return accountId;
  }

  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }

  public int getAccountTypeId() {
    return accountTypeId;
  }

  public void setAccountTypeId(int accountTypeId) {
    this.accountTypeId = accountTypeId;
  }

  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }


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
