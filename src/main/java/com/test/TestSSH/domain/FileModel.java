package com.test.TestSSH.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * 
 * @author liudi
 * @date 2018年1月17日
 */
@Entity(name = "file")  
public class FileModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String oName;
    private String saveName;
    private String path;
    private Date createTime;
    
    @Id
    @Column(name = "id", unique = true,  nullable = false, insertable = false, updatable = false)  
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Column(name = "o_name", nullable = false)  
    public String getoName() {
        return oName;
    }
    public void setoName(String oName) {
        this.oName = oName;
    }
    @Column(name = "save_name", nullable = false)  
    public String getSaveName() {
        return saveName;
    }
    public void setSaveName(String saveName) {
        this.saveName = saveName;
    }
    @Column(name = "path", nullable = false)  
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    @Column(name = "create_time", nullable = false)  
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    
}
