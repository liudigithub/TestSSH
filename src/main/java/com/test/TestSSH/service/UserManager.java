package com.test.TestSSH.service;

import java.util.List;

import com.test.TestSSH.domain.User;

/**
 * 
 * 
 * @author liudi
 * @date 2018Äê1ÔÂ16ÈÕ
 */
public interface UserManager {
    User load(Integer id);  
    User get(Integer id);  
    List<User> findAll();  
    void persist(User entity);  
    Integer save(User entity);  
    void saveOrUpdate(User entity);  
    void delete(Integer id);  
    void flush();  
}
