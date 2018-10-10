package db.mapper;

import db.model.User;

public interface UserMapper {
	
	int insertUser(User user);
	int updateUserPasswordByName(User user);
	int deleteUser(User user);
	User selectUser(User user);//only one user will be selected

}
