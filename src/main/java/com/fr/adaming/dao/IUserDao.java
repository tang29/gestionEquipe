package com.fr.adaming.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fr.adaming.entity.User;

@Repository
public interface IUserDao extends JpaRepository<User, Long>{


	@Query(value="From User where email = :emailParam and pwd=:pwdParam")
	public User findByEmailAndPwd(@Param("emailParam")String email,@Param("pwdParam")String pwd);
	
	
}
