package moneymanager.backend.api;

import moneymanager.backend.model.UserEntity;

public interface UserBuilder {

  UserDto build(UserEntity user);

}
