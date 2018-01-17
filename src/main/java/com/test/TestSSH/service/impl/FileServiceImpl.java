package com.test.TestSSH.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.TestSSH.dao.FileDao;
import com.test.TestSSH.domain.FileModel;
import com.test.TestSSH.service.FileService;

/**
 * 
 * 
 * @author liudi
 * @date 2018年1月17日
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired  
    private FileDao fileDao;  
    
    @Override
    public FileModel load(Integer id) {
        return fileDao.load(id);
    }

    @Override
    public FileModel get(Integer id) {
        return fileDao.get(id);
    }

    @Override
    public List<FileModel> findAll() {
        return fileDao.findAll();
    }

    @Override
    public void persist(FileModel entity) {
        fileDao.persist(entity);
    }

    @Override
    public Integer save(FileModel entity) {
        return fileDao.save(entity);
    }

    @Override
    public void saveOrUpdate(FileModel entity) {
        fileDao.saveOrUpdate(entity);
    }

    @Override
    public void delete(Integer id) {
        fileDao.delete(id);
    }

    @Override
    public void flush() {
        fileDao.flush();
    }

}
