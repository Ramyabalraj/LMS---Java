
package com.kgisl.resources.controller;
import java.util.*;

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
  List<UserResources> ulist=userResourcesService.get();
      int[] uresId = ulist.toArray();
      for (int obj : uresId) {
            System.out.print(obj.resId + " "); 
    } 
      Set<Integer> mySet = new HashSet<>();
      for(int y: resId){
  System.out.println("hii"+y);
         mySet.add(y);
  
      }
      for(int x: mySet){
        userResourcesService.create(userId,x);  
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
