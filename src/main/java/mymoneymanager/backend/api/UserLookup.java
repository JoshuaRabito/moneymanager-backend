package mymoneymanager.backend.api;

import mymoneymanager.backend.model.UserDto;
import mymoneymanager.backend.model.UserEntity;

public interface UserLookup {

  UserDto lookupUser(String firstName, String lastName);

  UserEntity getUserEntity(String firstName, String lastName);

}
