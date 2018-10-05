package com.sudarshan.myapp.SpringBootApp.repository;

import org.springframework.data.repository.CrudRepository;

import com.sudarshan.myapp.SpringBootApp.model.Role;

/**
 * 
 * @author ksudarshan2
 *
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
	
}
