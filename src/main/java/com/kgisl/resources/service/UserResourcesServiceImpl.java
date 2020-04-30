  
package com.kgisl.resources.service;

import java.util.*;  

import javax.transaction.Transactional;

import com.kgisl.resources.entity.*;

import com.kgisl.resources.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserResourcesServiceImpl implements UserResourcesService {

    @Autowired
    UserResourcesRepository userResourcesRepository;

    public UserResources create(int userId,int resId){
     
      userResourcesRepository.log(userId,resId);
       return null;
    }
    public List<UserResources> get(){
    return userResourcesRepository.findAll();
    }
     public UserResources findById(Long id){
     return userResourcesRepository.findById(id).orElse(null);
   }
    public void delete(Long id){
     userResourcesRepository.deleteById(id);
    }
}
