package com.kgisl.resources.service;
import java.util.List;
import com.kgisl.resources.entity.*;



public interface UserResourcesService {

    public UserResources create(int userId,long resId);
    public List<UserResources> get();
    public UserResources findById(Long id);
    public void delete(Long id);
 

}
