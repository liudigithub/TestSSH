package com.test.TestSSH.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.test.TestSSH.dao.UserDao;
import com.test.TestSSH.domain.User;

/**
 * 
 * 
 * @author liudi
 * @date 2018��1��16��
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired  
    private SessionFactory sessionFactory;  
    @Autowired
    private HibernateTemplate hibernateTemplate;
    
    private Session getCurrentSession() {  
        return sessionFactory.getCurrentSession();  
    }  
  
    @Override  
    public User load(Integer id) {  
        return hibernateTemplate.load(User.class, id);
//        return getCurrentSession().load(User.class, id);  
    }  
  
    @Override  
    public User get(Integer id) {  
        return getCurrentSession().get(User.class, id);  
    }  
  
    @SuppressWarnings("unchecked")  
    @Override  
    public List<User> findAll() {  
        return getCurrentSession().createQuery("from user").getResultList();  
    }  
  
    @Override  
    public void persist(User entity) {  
        getCurrentSession().persist(entity);  
    }  
  
    @Override  
    public Integer save(User entity) {  
        try{
            Integer count = (Integer)getCurrentSession().save(entity);
            return entity.getId();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }  
  
    @Override  
    public void saveOrUpdate(User entity) {  
        getCurrentSession().saveOrUpdate(entity);  
    }  
  
    @Override  
    public void delete(Integer id) {  
        getCurrentSession().delete(this.get(id));  
    }  
  
    @Override  
    public void flush() {  
        getCurrentSession().flush();  
    }  
  

}
