package mymoneymanager.backend.api;

import java.util.List;
import mymoneymanager.backend.model.Deduction;
import mymoneymanager.backend.model.DeductionEntity;

public interface DeductionBuilder {

  List<DeductionEntity> buildDeductions(List<Deduction> deductions);

}
