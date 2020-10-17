package mymoneymanager.backend.api;

import mymoneymanager.backend.model.UserDto;
import mymoneymanager.backend.model.UserEntity;

public interface UserBuilder {

  UserDto build(UserEntity user);

}
