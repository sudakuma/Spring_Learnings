package com.sudarshan.myapp.SpringBootApp.repository;

import org.springframework.data.repository.CrudRepository;

import com.sudarshan.myapp.SpringBootApp.model.User;

/**
 * 
 * @author ksudarshan2
 *
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
