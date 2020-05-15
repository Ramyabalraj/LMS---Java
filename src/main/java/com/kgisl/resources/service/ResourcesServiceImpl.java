  
  
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
     Resources r=new Resources(0,"https://userspringboot.herokuapp.com/images/js2.png","Java Script Basics 1","Java Script","Video","LMS.com",l);
      Resources r1=new Resources(0,"https://userspringboot.herokuapp.com/images/js1.png","Java Script Fundamentals 1","Java Script","Video","LMS.com",l);
      Resources r2=new Resources(0,"https://userspringboot.herokuapp.com/images/java1.png","AngularJS : Getting started 1","AngularJS","Video","LMS.com",l);
      Resources r3=new Resources(0,"https://userspringboot.herokuapp.com/images/angu1.png","Java Basics 1","Java","Video","LMS.com",l);
     Resources r4=new Resources(0,"https://userspringboot.herokuapp.com/images/angjs1.jpg	","Angular First Look ","Angular","Video","LMS.com",l);
     Resources r5=new Resources(0,"https://userspringboot.herokuapp.com/images/ts.png","AngularJS with TypeScript","AngularJS","Video","LMS.com",l2);
     Resources r6=new Resources(0,"https://userspringboot.herokuapp.com/images/try.jpg","Angular Big Look","Angular","Video","LMS.com",l3);
     Resources r7=new Resources(0,"https://userspringboot.herokuapp.com/images/python1.jpg","Python Machine Learning","Python","Video","LMS.com",l);
     Resources r8=new Resources(0,"	https://userspringboot.herokuapp.com/images/anjdepth.jpg","Angular Js InDepth ","Angular Js","Video","LMS.com",l3);
     Resources r9=new Resources(0,"	https://userspringboot.herokuapp.com/images/ML-made-easy-Python.jpg","Python Data science","Python","Video","LMS.com",l3);
     Resources r10=new Resources(0,"	https://userspringboot.herokuapp.com/images/python1.jpg","Python Basics","Python","Video","LMS.com",l);
     Resources r11=new Resources(0,"","Java Script: ES6","JS ES6","Video","LMS.com",l3);
     Resources r12=new Resources(0,"https://userspringboot.herokuapp.com/images/core%20java.jpg","Java","Java","Video","LMS.com",l);
     Resources r13=new Resources(0,"https://userspringboot.herokuapp.com/images/j3.png","Java 8","Java","Video","LMS.com",l2);
      Resources r14=new Resources(0,"https://userspringboot.herokuapp.com/images/core%20java.jpg","Core Java","Java","Video","LMS.com",l3);
     Resources r15=new Resources(0,"https://userspringboot.herokuapp.com/images/nodejs.jpg","Introduction to Node JS","Node JS","Video","LMS.com",l);
     Resources r16=new Resources(0,"https://userspringboot.herokuapp.com/images/adnodejs.jpg","Advanced Node JS","Node JS","Video","LMS.com",l3);
      Resources r17=new Resources(0,"https://userspringboot.herokuapp.com/images/nodejs.png","Node JS Express","Node JS","Video","LMS.com",l2);
     Resources r18=new Resources(0,"https://userspringboot.herokuapp.com/images/serv.png","Spring Boot Microservices ","Spring Boot Microservices","Video","LMS.com",l2);
     Resources r19=new Resources(0,"","Spring Framework","Spring","Video","LMS.com",l2);
      Resources r20=new Resources(0,"https://userspringboot.herokuapp.com/images/sp2.jpg","Spring Fundamentals","Spring","Video","LMS.com",l);
     Resources r21=new Resources(0,"https://userspringboot.herokuapp.com/images/hb.jpg","Hibernate","Hibernate","Video","LMS.com",l2);
     Resources r22=new Resources(0,"https://userspringboot.herokuapp.com/images/jq1.png","Jquery","Jquery","Video","LMS.com",l);
    //  resourcesRepository.save(r);
    //  resourcesRepository.save(r2);
    //  resourcesRepository.save(r3);
    //  resourcesRepository.save(r4);
    //  resourcesRepository.save(r5);
    //  resourcesRepository.save(r6);
    //  resourcesRepository.save(r7);
    //  resourcesRepository.save(r8);
     List<Resources> res = Arrays.asList(r,r1,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16,r17,r18,r19,r20,r21,r22);
     List<Resources> list = resourcesRepository.saveAll(res);
    //  List<Resources> list=  get();
     return list;

    }
    else{

     if(b==false ){
         resourcesRepository.save(resources);
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
