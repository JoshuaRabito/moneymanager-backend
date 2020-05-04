package mymoneymanager.backend.repository;

import org.springframework.data.repository.CrudRepository;
import mymoneymanager.backend.model.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long>{
  
  UserEntity findByName(String lastName, String firstName);
  
  UserEntity findById(long id);

  

}
