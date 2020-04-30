


package com.kgisl.resources.entity;
import javax.persistence.*;
import javax.persistence.JoinColumn;
import com.kgisl.resources.entity.Resources;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.*;
/**
 * User
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "user")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="USER_ID")
public   Long userId;
private String userName;
@Column(unique = true)
public   String userEmail;
private String userPassword;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade =  {CascadeType.ALL})
	//@JoinColumn(name = "userId")
    private List<Resources> resources=new ArrayList<Resources>();
   //private Set<Item> items;
     /**
     * @return the resources
     */
    public List<Resources> getResources() {
        return resources;
    }

    /**
     * @param resources the resources to set
     */
    public void setResources(List<Resources> resources) {
        this.resources = resources;
    }

     
    /**
     * @return the userid
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return the username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param username the username to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

      /**
     * @return the useremail
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * @param useremail the useremail to set
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * @return the userpassword
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * @param userPassword the userpassword to set
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}