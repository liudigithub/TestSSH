package com.test.TestSSH.service;

import java.util.List;

import com.test.TestSSH.domain.FileModel;

/**
 * 
 * 
 * @author liudi
 * @date 2018年1月17日
 */
public interface FileService {
    FileModel load(Integer id);  
    FileModel get(Integer id);  
    List<FileModel> findAll();  
    void persist(FileModel entity);  
    Integer save(FileModel entity);  
    void saveOrUpdate(FileModel entity);  
    void delete(Integer id);  
    void flush();  
}
