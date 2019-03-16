package service;

import domain.User;
import exception.UsersException;

public interface UserService  {
	public void register(User user) throws Exception ;


	public User login(User user) throws UsersException;
}
