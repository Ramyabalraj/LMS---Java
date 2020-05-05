  
package com.kgisl.resources.service;

import java.util.*;  

import javax.transaction.Transactional;

import com.kgisl.resources.entity.*;

import com.kgisl.resources.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LevelServiceImpl implements LevelService {

    @Autowired
    LevelRepository levelRepository;

    public Level create(Long id,String level){
    // String  levelname = level.getLevelName();
        
           System.out.println("level"+level);
           Level l=new Level(1,"Beginner");
           Level l2=new Level(2,"Intermediate");
           Level l3=new Level(3,"professional");
            levelRepository.save(l);
            levelRepository.save(l2);
           return levelRepository.save(l3);
     
    }
    public List<Level> get(){
    return levelRepository.findAll();
    }
    
}
