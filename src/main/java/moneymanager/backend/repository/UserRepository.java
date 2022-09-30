package moneymanager.backend.repository;

import moneymanager.backend.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

  UserEntity findByFirstNameAndLastName(String firstName, String lastName);

  UserEntity findById(long id);


}
