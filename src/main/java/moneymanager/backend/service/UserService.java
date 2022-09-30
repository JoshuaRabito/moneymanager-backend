package moneymanager.backend.service;

import moneymanager.backend.api.UserDto;
import moneymanager.backend.model.UserEntity;
import moneymanager.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private UserRepository userRepo;

  @Autowired
  public UserService(UserRepository userRepo) {
    super();
    this.userRepo = userRepo;
  }

  public UserEntity getUser(UserDto user) {
    return userRepo.findByFirstNameAndLastName(user.getFirstName(), user.getLastName());
  }

}
