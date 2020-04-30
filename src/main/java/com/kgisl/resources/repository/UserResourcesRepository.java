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
 * UserResourcesRepository
 */
public interface UserResourcesRepository extends JpaRepository<UserResources,Long>{
    @Modifying
    @Query(value = "insert into USER_RESOURCES (USER_USER_ID,RESOURCES_RES_ID) VALUES (:userId,:resId)", nativeQuery = true)
    @Transactional
 void log(@Param("userId") int userId,@Param("resId") int resId);
  

}
