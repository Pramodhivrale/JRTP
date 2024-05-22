package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.UserDtlsEntity;


@Repository
public interface UserDetailsRepo extends JpaRepository<UserDtlsEntity, Integer>{

	public UserDtlsEntity findByEmail(String email);

	public UserDtlsEntity findByPwd(String tempPassword);
	
	public UserDtlsEntity findByEmailAndPwd(String email,String Pwd);
}
