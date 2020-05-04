package mymoneymanager.backend.service;

import org.springframework.stereotype.Service;
import mymoneymanager.backend.api.UserDtoBuilder;
import mymoneymanager.backend.model.UserDto;
import mymoneymanager.backend.model.UserEntity;

@Service
public class UserDtoBuilderImpl implements UserDtoBuilder{

  @Override
  public UserDto build(UserEntity user) {
    UserDto userDto = new UserDto();
    userDto.setFirstName(user.getFirstName());
    userDto.setLastName(user.getLastName());
    userDto.setEmail(user.getEmail());
    
    return userDto;
  }

}
