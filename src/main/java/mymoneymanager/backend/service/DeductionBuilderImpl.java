package mymoneymanager.backend.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import mymoneymanager.backend.api.DeductionBuilder;
import mymoneymanager.backend.model.DeductionDTO;
import mymoneymanager.backend.model.DeductionEntity;
import mymoneymanager.backend.model.DeductionTypeEntity;
import mymoneymanager.backend.model.DeductionTypes;

@Service
public class DeductionBuilderImpl implements DeductionBuilder {

  @Override
  public List<DeductionEntity> buildDeductions(List<DeductionDTO> deductions) {
    List<DeductionEntity> deductionEntities = new ArrayList<DeductionEntity>();
    for (DeductionDTO deduction : deductions) {
      DeductionEntity entity = buildEntity(deduction);
      deductionEntities.add(entity);
    }
    return deductionEntities;
  }

  private DeductionEntity buildEntity(DeductionDTO deduction) {
    DeductionEntity entity = new DeductionEntity();
    entity.setAmount(deduction.getAmount());
    entity.setDeductionType(buildDeductionType(deduction));
    entity.setName(deduction.getName());
    return entity;
  }

  private DeductionTypeEntity buildDeductionType(DeductionDTO deduction) {
    DeductionTypeEntity typeEntity = new DeductionTypeEntity();
    typeEntity.setDeductionType(deduction.getType());
    typeEntity.setDeductionTypeId(DeductionTypes.getIdByValue(deduction.getType()));
    return typeEntity;
  }

  @Override
  public List<DeductionDTO> buildDeductionsDTOs(List<DeductionEntity> deductions) {
    List<DeductionDTO> dtos = new ArrayList<>();
    for (DeductionEntity entity : deductions) {
      DeductionDTO dto = new DeductionDTO();
      dto.setAmount(entity.getAmount());
      dto.setName(entity.getName());
      dto.setType(entity.getDeductionType().getDeductionType());
      dtos.add(dto);
    }
    return dtos;
  }

}
