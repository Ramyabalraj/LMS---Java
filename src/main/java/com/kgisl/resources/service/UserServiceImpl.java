  
package com.kgisl.resources.service;

import java.util.*;  

import javax.transaction.Transactional;

import com.kgisl.resources.entity.User;
import com.kgisl.resources.entity.Resources;
import com.kgisl.resources.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public User create(User user) {
   
   String email=user.getUserEmail();
   String pass=user.getUserPassword();
   String name=user.getUserName();
 if(email==null &&  pass==null && name==null){
  System.out.println("null");
        }
        else{
        Boolean e=  userRepository.existsByuserEmail(email);
        Boolean b=  userRepository.existsByuserPassword(pass);

       if(e == false && b == false){
      
      return userRepository.save(user);
        }
        }
     System.out.println("Already exists...");
    return null;
    
     }
 
    public User login(User user){
     String email=user.getUserEmail();
     String pass=user.getUserPassword();
     if(email=="" && pass==""){
     System.out.println("null");
        }
        else{
        Boolean e=  userRepository.existsByuserEmail(email);
        Boolean b=  userRepository.existsByuserPassword(pass);
        System.out.println(b);
        List<User> list=get();
       if(e == true && b == true){
    long  userId=0;
     for (User user1 : list) {
        if (user1.userEmail.equals(email)) {
            userId = user1.userId;
            System.out.println(userId);
            break;
        } 
    }
   User u= findById(userId);
      return u;
        }
        }
     System.out.println("Invalid login...");
     return null;
 }

    public List<User> get() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User update(Long id,User user) {
        String email=user.getUserEmail();
        if(email == "" && user.getUserName() == ""){
        System.out.println("null");
        }
        else{
         Boolean e= false;
         if(e == false){
         User t = userRepository.getOne(id);
         t.setUserName(user.getUserName());
         t.setUserEmail(user.getUserEmail());
         t.setUserPassword(user.getUserPassword());
         t.setResources(user.getResources());
        return userRepository.save(t);
        }
            }
  
        System.out.println("Already exists...");
        return null;
       
       
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

//     public User userResources(Long id,User resources){
//           User u = userRepository.getOne(id);
//            u.setResources(resources);
//           return userRepository.save(u); 
//    }

}
