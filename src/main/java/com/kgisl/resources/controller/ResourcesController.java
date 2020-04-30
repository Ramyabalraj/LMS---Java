
package com.kgisl.resources.controller;
import java.util.*;
import com.kgisl.resources.entity.User;
import com.kgisl.resources.entity.Resources;
import com.kgisl.resources.service.ResourcesService;
import com.kgisl.resources.service.UserService;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
* UserController
*/

@CrossOrigin(origins = "*")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@RestController
@RequestMapping("/api/resources")
public class ResourcesController {

   @Autowired
   private ResourcesService resourcesService;
   
   @Autowired
   private UserService userService;

   

   @PostMapping(value = "/", headers = "Accept=application/json")
   public ResponseEntity<Resources> create(@RequestBody Resources resources) {
      
       Resources actual=resourcesService.create(resources);
        if (actual == null) {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
       HttpHeaders headers = new HttpHeaders();
      return new ResponseEntity<>(actual,headers, HttpStatus.CREATED);
   }

  @GetMapping("/")
   public @ResponseBody ResponseEntity<List<Resources>> all() {
       return new ResponseEntity<>(resourcesService.get(), HttpStatus.OK);
   }
   @PostMapping("/getresources/")
   public @ResponseBody ResponseEntity<List<Resources>> allResources(Resources resources) {
     List<Resources> list= resourcesService.getResources(resources);
      return new ResponseEntity<>(list, HttpStatus.OK);
   }


   @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Resources> getTeamById(@PathVariable("id") long id) {
       Resources resources = resourcesService.findById(id);
       if (resources == null) {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity<>(resources, HttpStatus.OK);
   }

   @PutMapping(value = "/{id}", headers="Accept=application/json")
   public ResponseEntity<Resources> update(@PathVariable("id") long id,@RequestBody Resources current)
   {
       Resources resources=resourcesService.update(id,current);
        if (resources == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      
        }
         return new ResponseEntity<>(resources,HttpStatus.OK);
   }

   @DeleteMapping(value="/{id}", headers ="Accept=application/json")
   public ResponseEntity<Resources> delete(@PathVariable("id") Long id){
       Resources resources = resourcesService.findById(id);
       if (resources == null) {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       resourcesService.deleteById(id);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
//    @PostMapping(value = "/userresources/", headers = "Accept=application/json")
//    public ResponseEntity<User> userResources(@PathVariable("id") long id,@RequestBody User resources) {
      
//      return userService.userResources(id,resources);
//         // return new ResponseEntity<>(r,headers,HttpStatus.OK);
//    }


}
