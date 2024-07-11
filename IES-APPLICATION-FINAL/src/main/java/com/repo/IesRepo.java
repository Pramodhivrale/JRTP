package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.IesUserEntity;

@Repository
public interface IesRepo extends JpaRepository<IesUserEntity, Integer>{

	public IesUserEntity findByUserEmail(String userEmail);

	//public IesUserEntity findByEmailAndPwd(String email,String pwd);

	public IesUserEntity findByUserEmailAndUserPwd(String userEmail, String userPwd);

}
