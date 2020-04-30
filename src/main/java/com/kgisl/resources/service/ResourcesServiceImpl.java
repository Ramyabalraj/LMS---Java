  
package com.kgisl.resources.service;

import java.util.*;  

import javax.transaction.Transactional;

import com.kgisl.resources.entity.Resources;
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
    if(resourcesName == null){
    System.out.println("null resources");
    }
    else{
     if(b==false ){
     Resources r=new Resources(0,"Java Script 1","Java Script","Video","LMS.com");
     Resources r2=new Resources(0,"Java 1","Java","Video","LMS.com");
     Resources r3=new Resources(0,"Angular 1","Angular","Video","LMS.com");
     Resources r4=new Resources(0,"Spring Boot 1","Spring Boot","Video","LMS.com");
     resourcesRepository.save(r);
     resourcesRepository.save(r2);
     resourcesRepository.save(r3);
     resourcesRepository.save(r4);
     System.out.println("resources"+resources.getResId());
     List<Resources> list=  get();
     return list;
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
