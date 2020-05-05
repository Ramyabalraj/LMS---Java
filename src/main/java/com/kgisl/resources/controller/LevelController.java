
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
@RequestMapping("/api/level")
public class LevelController {

   @Autowired
   private LevelService levelService;

   // @Autowired
   // private ModelMapper modelMapper;
@PostMapping(value = "/", headers = "Accept=application/json")
   public ResponseEntity<Level> create(Long id,String level) {
      
       Level actual=levelService.create(id,level);
       return new ResponseEntity<>(actual, HttpStatus.CREATED);
   }
   @GetMapping("/")
   public @ResponseBody ResponseEntity<List<Level>> all() {

       return new ResponseEntity<>(levelService.get(), HttpStatus.OK);
   }

  
  
  
}
