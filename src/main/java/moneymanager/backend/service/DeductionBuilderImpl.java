package moneymanager.backend.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import moneymanager.backend.api.DeductionBuilder;
import moneymanager.backend.api.DeductionDTO;
import moneymanager.backend.model.DeductionEntity;
import moneymanager.backend.model.DeductionTypeEntity;
import moneymanager.backend.model.DeductionTypes;
import org.springframework.stereotype.Service;

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

  @Override
  public DeductionDTO buildSumDeduction(List<DeductionEntity> deductionEntities) {
    List<DeductionDTO> dtos = buildDeductionsDTOs(deductionEntities);

    BigDecimal sum = dtos.stream().map(DeductionDTO::getAmount)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
    DeductionDTO dto = new DeductionDTO();
    dto.setAmount(sum);
    dto.setName(dtos.get(0).getName());
    return dto;
  }

}
