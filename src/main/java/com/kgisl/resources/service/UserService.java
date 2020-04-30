package com.kgisl.resources.service;
import java.util.List;
import com.kgisl.resources.entity.Resources;
import com.kgisl.resources.entity.User;


public interface UserService {

    public User create(User user);
    public List<User> get();
    public User findById(Long id);
    public User update(Long id,User user);
    public void deleteById(Long id);
    public User login(User user);
    // User userResources(Long id,User resources);
}
