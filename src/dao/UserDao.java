package dao;

import domain.User;

public interface UserDao {
	/**
	 * 添加用户信息
	 * @param user
	 * @throws Exceotion 
	 * @Title: addUser   
	 * @Description: TODO
	 * @param @param user
	 * @param @throws Exceotion       
	 * @return void   
	 * @throws
	 */
	public void addUser(User user) throws Exception ;
	public User findUser(User user)throws Exception ;
}
