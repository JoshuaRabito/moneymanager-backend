package mymoneymanager.backend.api;

import mymoneymanager.backend.model.UserDto;

public interface UserLookup {

  UserDto lookupUser(String firstName, String lastName);

}
