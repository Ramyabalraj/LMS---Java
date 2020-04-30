package com.kgisl.resources.entity;
import javax.persistence.*;
import javax.persistence.JoinColumn;
import com.kgisl.resources.entity.Resources;
import com.kgisl.resources.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.*;
/**
 * User_Resources
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "USER_RESOURCES")
public class UserResources {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="URES_ID")
  private   Long id;
  @ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "USER_ID") 
  private User user;
  @ManyToOne(cascade = CascadeType.ALL)
  //  @JoinColumn(name = "RES_ID") 
  private  Resources resources;
 
    
   
    public User getUser() {
        return user;
    }
 
    public void setUser(User user) {
        System.out.println("user"+user);
        this.user = user;
    }
 
    
    
    public  Resources getResources() {
        return resources;
    }
 
    public void setResources(Resources resources) {
        this.resources = resources;
    }

 

     
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

   
}