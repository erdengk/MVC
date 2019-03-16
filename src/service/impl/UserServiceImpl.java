package service.impl;

import service.UserService;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import exception.UsersException;
public class UserServiceImpl implements UserService {
	
	
	UserDao userDao = new UserDaoImpl();
	
	public void register(User user) throws Exception {
		userDao.addUser(user);
	}

	public User login(User user) throws UsersException {
		User u= null ;
		try {
		u = 	userDao.findUser(user);
		if (u==null) {
			System.out.println("用户名或密码不正确 ");
			 
		}
		} catch (Exception e) {
			e.printStackTrace();
			// 写入日志
		}
		return u;
	}

}
