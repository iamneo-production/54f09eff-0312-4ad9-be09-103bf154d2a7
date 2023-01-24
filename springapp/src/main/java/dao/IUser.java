package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.User;

public interface IUser extends JpaRepository<User,Integer>{

	@Query(value = "SELECT*FROM user WHERE uname=?", nativeQuery = true)
	public User findByUName(String uname);

	 @Query(value = "SELECT*FROM user WHERE upassword=?", nativeQuery = true)
	  public User findByUPassword(String upassword);

}
