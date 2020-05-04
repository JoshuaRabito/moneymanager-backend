package mymoneymanager.backend.api;

import mymoneymanager.backend.model.UserDto;
import mymoneymanager.backend.model.UserEntity;

public interface UserDtoBuilder {

  UserDto build(UserEntity user);

}
