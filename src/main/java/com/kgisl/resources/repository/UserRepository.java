package com.kgisl.resources.repository;

import com.kgisl.resources.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TeamRepository
 */
public interface UserRepository extends JpaRepository<User,Long>{
boolean existsByuserEmail(String email);
boolean existsByuserName(String name) ;  
boolean existsByuserPassword(String pass) ; 

}
