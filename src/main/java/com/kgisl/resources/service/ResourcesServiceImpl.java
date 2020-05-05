  
package com.kgisl.resources.service;

import java.util.*;  

import javax.transaction.Transactional;

import com.kgisl.resources.entity.*;
import com.kgisl.resources.repository.ResourcesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ResourcesServiceImpl implements ResourcesService {

    @Autowired
    ResourcesRepository resourcesRepository;

          
    public Resources create(Resources resources){
    String resourcesName=resources.getResName();
    System.out.println(resourcesName);
    Boolean b=resourcesRepository.existsByresName(resourcesName);
    if(b==false){
    return resourcesRepository.save(resources);
    }
    else {
    return null;
    } 
   
    
    }
    public List<Resources> getResources(Resources resources){
    String resourcesName=resources.getResName();
    System.out.println(resourcesName);
    Boolean b=resourcesRepository.existsByresName(resourcesName);
    System.out.println(b);
    if(resourcesName == null){
    System.out.println("null resources");
      Level l=new Level(1,"Beginner");
      Level l2=new Level(2,"Intermediate");
      Level l3=new Level(3,"Professional");
     Resources r=new Resources(0,"Java Script 1","Java Script","Video","LMS.com",l);
     Resources r2=new Resources(0,"Java 1","Java","Video","LMS.com",l);
     Resources r3=new Resources(0,"Angular 1","Angular","Video","LMS.com",l);
     Resources r4=new Resources(0,"Spring Boot 3","Spring Boot","Video","LMS.com",l);
     Resources r5=new Resources(0,"Java Script 2","Java Script","Video","LMS.com",l2);
     Resources r6=new Resources(0,"Java 2","Java","Video","LMS.com",l2);
     Resources r7=new Resources(0,"Angular 3","Angular","Video","LMS.com",l3);
     Resources r8=new Resources(0,"Spring Boot 3","Spring Boot","Video","LMS.com",l3);
     resourcesRepository.save(r);
     resourcesRepository.save(r2);
     resourcesRepository.save(r3);
     resourcesRepository.save(r4);
     resourcesRepository.save(r5);
     resourcesRepository.save(r6);
     resourcesRepository.save(r7);
     resourcesRepository.save(r8);

    
     List<Resources> list=  get();
     return list;

    }
    else{

     if(b==false ){
        System.out.println("resources  is Already there...");
            }
     else{
     System.out.println("resource is Already there...");
     }
    }
    
     return null;
    }
    public List<Resources> get(){
     
     return resourcesRepository.findAll();
   }

   public Resources findById(Long id){
 return resourcesRepository.findById(id).orElse(null);
   }

    public Resources update(Long id,Resources resources){
  Resources r = resourcesRepository.getOne(id);
  r.setResName(resources.getResName());
  r.setResType(resources.getResType());
  r.setResTech(resources.getResTech());
  r.setResUrl(resources.getResUrl());
  return resourcesRepository.save(r);
}
   public void deleteById(Long id){
 resourcesRepository.deleteById(id);
   }

   
}
