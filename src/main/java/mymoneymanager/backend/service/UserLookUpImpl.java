package mymoneymanager.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mymoneymanager.backend.api.UserDtoBuilder;
import mymoneymanager.backend.api.UserLookup;
import mymoneymanager.backend.model.UserDto;
import mymoneymanager.backend.model.UserEntity;
import mymoneymanager.backend.repository.UserRepository;

@Service
public class UserLookUpImpl implements UserLookup {

  private UserRepository userRepo;
  
  private UserDtoBuilder userDtoBuilder;
  
  
  @Autowired
  public UserLookUpImpl(UserRepository userRepo, UserDtoBuilder userDtoBuilder) {
    this.userRepo = userRepo;
    this.userDtoBuilder = userDtoBuilder;
  }



  @Override
  public UserDto lookupUser(String firstName, String lastName) {

    UserEntity user = userRepo.findByName(lastName, firstName);
    if (user != null) {
      return userDtoBuilder.build(user);
    }
    throw new IllegalArgumentException(
        String.format("No user found by the name, %s %s.", firstName, lastName));


  }

}
