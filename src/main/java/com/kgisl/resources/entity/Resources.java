





package com.kgisl.resources.entity;
import com.kgisl.resources.entity.User;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.*;
import javax.persistence.Column;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Resources
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Resources {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
 @GeneratedValue
   @Column(name="RES_ID")
    public Long resId;
    private String resImg;
    private String resName;
    private String resTech;
    private String resType;
    private String resUrl;
  @ManyToOne(cascade = CascadeType.ALL)
// //@JoinColumn(name = "userId", updatable = false, insertable = true)
   private Level level;
   

     /**
     * @param Level the level to set
     */
     public Level getLevel() {
        return level;
    }

   public void setLevel(Level level) {
       this.level = level;
   }
    
   
   
    /**
     * @return the resId
     */
    public Long getResId() {
        return resId;
    }

    /**
     * @param resId the resId to set
     */
    public void setResId(Long ResId) {
        this.resId = resId;
    }

    /**
     * @return the resName
     */
    public String getResName() {
        return resName;
    }

    /**
     * @param resName the resName to set
     */
    public void setResName(String resName) {
        this.resName = resName;
    }
     /**
     * @return the resImg
     */
    public String getResImg() {
        return resImg;
    }

    /**
     * @param resImg the resName to set
     */
    public void setResImg(String resImg) {
        this.resImg = resImg;
    }

      /**
     * @return the resTech
     */
    public String getResTech() {
        return resTech;
    }

    /**
     * @param resTech the resTech to set
     */
    public void setResTech(String resTech) {
        this.resTech = resTech;
    }

        /**
     * @return the resType
     */
    public String getResType() {
        return resType;
    }

    /**
     * @param resType the resType to set
     */
    public void setResType(String resType) {
        this.resType = resType;
    }

    /**
     * @return the resUrl
     */
    public String getResUrl() {
        return resUrl;
    }

    /**
     * @param resUrl the resUrl to set
     */
    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }
     public Resources(long resId,String resImg,String resName,String resTech,String resType,String resUrl,Level level){
     this.resId=resId;
 this.resImg=resImg;
     this.resName=resName;
     this.resTech=resTech;
     this.resType=resType;
     this.resUrl=resUrl;
     this.level=level;
     
     }
     public Resources(){
         
     }
}
