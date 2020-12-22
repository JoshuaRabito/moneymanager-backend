package mymoneymanager.backend.service;

import org.springframework.stereotype.Service;
import mymoneymanager.backend.model.UserDto;
import mymoneymanager.backend.model.UserEntity;
import mymoneymanager.backend.repository.UserRepository;

@Service
public class UserService {
  
  private UserRepository userRepo;

  public UserEntity getUser(UserDto user) {
    return userRepo.findByFirstNameAndLastName(user.getFirstName(), user.getLastName());
  }

}
