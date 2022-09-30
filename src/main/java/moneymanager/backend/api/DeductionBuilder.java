package moneymanager.backend.api;

import java.util.List;
import moneymanager.backend.model.DeductionEntity;

public interface DeductionBuilder {

  List<DeductionEntity> buildDeductions(List<DeductionDTO> deductions);

  List<DeductionDTO> buildDeductionsDTOs(List<DeductionEntity> deductions);

  DeductionDTO buildSumDeduction(List<DeductionEntity> deductionEntities);

}
