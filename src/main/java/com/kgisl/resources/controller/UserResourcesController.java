
package com.kgisl.resources.controller;
import java.util.List;

import com.kgisl.resources.entity.*;
import com.kgisl.resources.service.*;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
* UserResourcesController
*/

@CrossOrigin(origins = "*")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@RestController
@RequestMapping("/api/userresources")
public class UserResourcesController {

   @Autowired
   private UserResourcesService userResourcesService;

   // @Autowired
   // private ModelMapper modelMapper;

   @GetMapping(value = "/{userId}/{resId}/", headers = "Accept=application/json")
   public ResponseEntity<UserResources> create(@RequestParam("userId") int userId,@RequestParam("resId[]") int resId[]) {
//       for (int x : resId)
//        { 
//        userResourcesService.create(userId,x);
//         }
            int b[] = resId.clone(); 
      for(int y: b){
  System.out.println("hii"+y);
      }

     for(int i=0;i<resId.length;i++){
         for(int j=0;j<resId.length;j++){
        if(b[i]==resId[j]){
       userResourcesService.create(userId,b[i]);
           }
           else{
              userResourcesService.create(userId,b[i]);   
           }
         }
     }
    return new ResponseEntity<>(HttpStatus.CREATED);
   }

  

   @GetMapping("/")
   public @ResponseBody ResponseEntity<List<UserResources>> all() {
       return new ResponseEntity<>(userResourcesService.get(), HttpStatus.OK);
   }

  
   @DeleteMapping(value="/{id}", headers ="Accept=application/json")
   public ResponseEntity<UserResources> delete(@PathVariable("id") Long id){
       UserResources userResources = userResourcesService.findById(id);
      userResourcesService.delete(id);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
  
}
