package mymoneymanager.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mymoneymanager.backend.model.UserDto;
import mymoneymanager.backend.model.UserEntity;
import mymoneymanager.backend.repository.UserRepository;

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
