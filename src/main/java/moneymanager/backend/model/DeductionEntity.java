package moneymanager.backend.model;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Digits;

@Entity(name = "deductions")
public class DeductionEntity {

  @Id
  @Column(name = "deduction_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long deductionId;

  @Column(name = "name")
  private String name;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "deduction_type_id")
  private DeductionTypeEntity deductionType;

  @Digits(integer = 8, fraction = 2)
  private BigDecimal amount;

  @ManyToOne
  @JoinTable(name = "account_deduction_xref", joinColumns = {@JoinColumn(name = "account_id")},
      inverseJoinColumns = {@JoinColumn(name = "deduction_id")})
  private AccountEntity accountEntity;

  @Column(name = "is_expired")
  private boolean isExpired;

  public Long getDeductionId() {
    return deductionId;
  }

  public void setDeductionId(Long deductionId) {
    this.deductionId = deductionId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DeductionTypeEntity getDeductionType() {
    return deductionType;
  }

  public void setDeductionType(DeductionTypeEntity deductionType) {
    this.deductionType = deductionType;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public AccountEntity getAccountEntity() {
    return accountEntity;
  }

  public void setAccountEntity(AccountEntity accountEntity) {
    this.accountEntity = accountEntity;
  }

  public boolean isExpired() {
    return isExpired;
  }

  public void setExpired(boolean isExpired) {
    this.isExpired = isExpired;
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountEntity, amount, deductionId, deductionType, isExpired, name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    DeductionEntity other = (DeductionEntity) obj;
    return Objects.equals(accountEntity, other.accountEntity)
        && Objects.equals(amount, other.amount) && Objects.equals(deductionId, other.deductionId)
        && Objects.equals(deductionType, other.deductionType) && isExpired == other.isExpired
        && Objects.equals(name, other.name);
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("DeductionEntity [deductionId=");
    builder.append(deductionId);
    builder.append(", name=");
    builder.append(name);
    builder.append(", deductionType=");
    builder.append(deductionType);
    builder.append(", amount=");
    builder.append(amount);
    builder.append(", accountEntity=");
    builder.append(accountEntity);
    builder.append(", isExpired=");
    builder.append(isExpired);
    builder.append("]");
    return builder.toString();
  }

}
