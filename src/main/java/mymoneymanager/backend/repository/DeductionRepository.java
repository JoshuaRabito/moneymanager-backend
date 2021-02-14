package mymoneymanager.backend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import mymoneymanager.backend.model.DeductionEntity;

public interface DeductionRepository extends JpaRepository<DeductionEntity, Long> {

  @Query("SELECT d FROM deductions d WHERE Upper(d.name) LIKE %:name% and d.deductionType.deductionTypeId = :deductionTypeId and isExpired = 0")
  public List<DeductionEntity> findByNameContaining(
      @Param("name")String name, @Param("deductionTypeId") int deductionTypeId);

}
