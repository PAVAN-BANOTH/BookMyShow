package com.bookmyshow.usersmodule.repository;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.bookmyshow.usersmodule.entity.User;

@Repository
public interface UserRegistrationRepository extends JpaRepository<User, Long> {
	public List<User> findByEmail(String email,Pageable pageable);
}