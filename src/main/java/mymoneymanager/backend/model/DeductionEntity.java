package mymoneymanager.backend.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "deductions")
public class DeductionEntity {

  @Id
  @Column(name = "deduction_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long deductionId;
  private String name;

  @Column(name = "deduction_type")
  private DeductionTypeEntity deductionType;
  private BigDecimal amount;

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



}
