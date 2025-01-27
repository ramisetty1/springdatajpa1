package com.telecom.signup.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.telecom.signup.entity.User;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByEmail(String email);
	
	@Query(value = "select * from user where email= :emailId and password= :pword ", nativeQuery = true)
	
	Optional<User> dbLoginWithQuery(@Param("emailId") String email, @Param("pword") String password);

}
