package moneymanager.backend.service;

import moneymanager.backend.api.UserBuilder;
import moneymanager.backend.api.UserDto;
import moneymanager.backend.model.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserBuilderImpl implements UserBuilder {

  @Override
  public UserDto build(UserEntity user) {
    UserDto userDto = new UserDto();
    userDto.setFirstName(user.getFirstName());
    userDto.setLastName(user.getLastName());
    userDto.setEmail(user.getEmail());

    return userDto;
  }

}
