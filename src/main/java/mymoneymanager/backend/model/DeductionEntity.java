package mymoneymanager.backend.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Digits;

@Entity(name = "deductions")
public class DeductionEntity {

  @Id
  @Column(name = "deduction_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long deductionId;
  private String name;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "deduction_type_id")
  private DeductionTypeEntity deductionType;
  
  @Digits(integer=4, fraction=2)
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
