package com.bookmyshow.usersmodule.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bookmyshow.usersmodule.entity.User;
import com.bookmyshow.usersmodule.repository.UserRegistrationRepository;



@Service
public class UserService {

    @Autowired
    private UserRegistrationRepository userRegistrationRepository;

    public List<User> getAllUserRegistrations() {
        return userRegistrationRepository.findAll();
    }

    public User getUserRegistrationById(Long id) {
        return userRegistrationRepository.findById(id).orElse(null);
    }

    public User createUserRegistration(User user) {
        return userRegistrationRepository.save(user);
    }

    public User updateUserRegistration(User user) {
        return userRegistrationRepository.save(user);
    }

    public void deleteUserRegistrationById(Long id) {
        userRegistrationRepository.deleteById(id);
    }
    public List<User> findUserWithSorting(String field){
    	return userRegistrationRepository.findAll(Sort.by(Sort.Direction.ASC,field));
    }
   /* public Page<User> findUserWithPagination(int offset,int pageSize){
    	Page<User> temp = userRegistrationRepository.findAll(PageRequest.of(offset, pageSize));
    	return temp;
    }
    
    public Page<User> findUserWithPaginationAndSorting(int offset,int pageSize,String field){
    	Page<User> users = userRegistrationRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
    	return users;
    }*/
    public List<User> getAllUser(int pageNo,int recordCount){
    	Pageable pageable = PageRequest.of(pageNo,recordCount,Sort.by("email"));
    	return userRegistrationRepository.findAll(pageable).get().toList();
    	
	
    }
    public List<User> getByEmail(String email,int pageNo,int recordCount){
    	Pageable pageable = PageRequest.of(pageNo,recordCount,Sort.by("email"));
    	return userRegistrationRepository.findByEmail(email, pageable);
    	
    	
    }
    
    
    
}
