package moneymanager.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "deduction_types")
public class DeductionTypeEntity {

  @Id
  @Column(name = "deduction_type_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer deductionTypeId;

  @Column(name = "deduction_type")
  private String deductionType;

  public Integer getDeductionTypeId() {
    return deductionTypeId;
  }

  public void setDeductionTypeId(Integer deductionTypeId) {
    this.deductionTypeId = deductionTypeId;
  }

  public String getDeductionType() {
    return deductionType;
  }

  public void setDeductionType(String deductionType) {
    this.deductionType = deductionType;
  }


}
