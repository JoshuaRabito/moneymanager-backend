package mymoneymanager.backend.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import mymoneymanager.backend.api.DeductionBuilder;
import mymoneymanager.backend.model.Deduction;
import mymoneymanager.backend.model.DeductionEntity;
import mymoneymanager.backend.model.DeductionTypeEntity;
import mymoneymanager.backend.model.DeductionTypes;

@Service
public class DeductionBuilderImpl implements DeductionBuilder {

  @Override
  public List<DeductionEntity> buildDeductions(List<Deduction> deductions) {
    List<DeductionEntity> deductionEntities = new ArrayList<DeductionEntity>();
    for (Deduction deduction : deductions) {
      DeductionEntity entity = buildEntity(deduction);
      deductionEntities.add(entity);
    }
    return deductionEntities;
  }

  private DeductionEntity buildEntity(Deduction deduction) {
    DeductionEntity entity = new DeductionEntity();
    entity.setAmount(deduction.getAmount());
    entity.setDeductionType(buildDeductionType(deduction));
    entity.setName(deduction.getName());
    return entity;
  }

  private DeductionTypeEntity buildDeductionType(Deduction deduction) {
    DeductionTypeEntity typeEntity = new DeductionTypeEntity();
    typeEntity.setDeductionType(deduction.getType());
    typeEntity.setDeductionTypeId(DeductionTypes.getId(deduction.getType()));
    return typeEntity;
  }

}
