package mymoneymanager.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="deduction_types")
public class DeductionTypeEntity {
  
  @Id
  @Column(name="deduction_type_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long deductionTypeId;
  
  @Column(name="deduction_type")
  private String deductionType;

  public Long getDeductionTypeId() {
    return deductionTypeId;
  }

  public void setDeductionTypeId(Long deductionTypeId) {
    this.deductionTypeId = deductionTypeId;
  }

  public String getDeductionType() {
    return deductionType;
  }

  public void setDeductionType(String deductionType) {
    this.deductionType = deductionType;
  }
  
  
  

}
