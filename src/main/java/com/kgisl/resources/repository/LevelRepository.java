package com.kgisl.resources.repository;

import com.kgisl.resources.entity.*;
import java.util.*;  
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query.*;
import javax.transaction.Transactional;

/**
 * LevelRepository
 */
public interface LevelRepository extends JpaRepository<Level,Long>
{
   
  

}
