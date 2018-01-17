package com.test.TestSSH.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.test.TestSSH.dao.FileDao;
import com.test.TestSSH.domain.FileModel;

/**
 * 
 * 
 * @author liudi
 * @date 2018年1月17日
 */
@Repository
public class FileDaoImpl implements FileDao {

    @Autowired  
    private SessionFactory sessionFactory;  
    @Autowired
    private HibernateTemplate hibernateTemplate;
    
    private Session getCurrentSession() {  
        return sessionFactory.getCurrentSession();  
    }  
    
    @Override
    public FileModel load(Integer id) {
        return hibernateTemplate.load(FileModel.class, id);
    }

    @Override
    public FileModel get(Integer id) {
        return getCurrentSession().get(FileModel.class, id);  
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<FileModel> findAll() {
        return getCurrentSession().createQuery("from file").getResultList();  
    }

    @Override
    public void persist(FileModel entity) {
        getCurrentSession().persist(entity);  
    }

    @Override
    public Integer save(FileModel entity) {
        return (Integer)getCurrentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(FileModel entity) {
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
