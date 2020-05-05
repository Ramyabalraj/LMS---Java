package com.kgisl.resources.entity;
import javax.persistence.*;
import javax.persistence.JoinColumn;
import com.kgisl.resources.entity.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.*;


/**
 * Level
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Level {
   @Id
 //  @GeneratedValue
  private  long levelId;
  public  String levelName;
 
    
   /**
     * @return the levelname
     */
    public String getLevelName() {
        return levelName;
    }

    /**
     * @param levelname the levelname to set
     */
    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    /**
     * @return the levelid
     */
    public Long LevelId() {
        return levelId;
    }

    /**
     * @param levelid the levelid to set
     */
    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }
  public Level(){

   }
 public  Level(long levelId,String levelName){
     this.levelId=levelId;
    this.levelName=levelName;
   }
}
