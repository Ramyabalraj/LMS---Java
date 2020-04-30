package com.kgisl.resources.service;
import java.util.List;
import com.kgisl.resources.entity.Resources;



public interface ResourcesService {

    public Resources create(Resources resources);
    public List<Resources> get();
     public List<Resources> getResources(Resources resources);
    public Resources findById(Long id);
    public Resources update(Long id,Resources resources);
    public void deleteById(Long id);
  
 
}
