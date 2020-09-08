package mymoneymanager.backend.api;

import java.util.List;
import mymoneymanager.backend.model.DeductionDTO;
import mymoneymanager.backend.model.DeductionEntity;

public interface DeductionBuilder {

  List<DeductionEntity> buildDeductions(List<DeductionDTO> deductions);

  List<DeductionDTO> buildDeductionsDTOs(List<DeductionEntity> deductions);

}
