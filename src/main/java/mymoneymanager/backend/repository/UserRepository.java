package mymoneymanager.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mymoneymanager.backend.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
  
  UserEntity findByFirstNameAndLastName(String firstName, String lastName);
  
  UserEntity findById(long id);

  

}
