


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
    private Long resId;
  
   
    private String resName;
    private String resTech;
    private String resType;
    private String resUrl;
//    @ManyToMany
// //@JoinColumn(name = "userId", updatable = false, insertable = true)
//     private List<User> user;
   

//      /**
//      * @param User the user to set
//      */
//      public List<User> getUser() {
//         return user;
//     }

//    public void setUser(List<User> user) {
//        this.user = user;
//    }
    
   
   
    /**
     * @return the resId
     */
    public Long getResId() {
        return resId;
    }

    /**
     * @param resId the resId to set
     */
    public void setResId(Long userId) {
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
     public Resources(long resId,String resName,String resTech,String resType,String resUrl){
     this.resId=resId;
     this.resName=resName;
     this.resTech=resTech;
     this.resType=resType;
     this.resUrl=resUrl;
     }
     public Resources(){
         
     }
}