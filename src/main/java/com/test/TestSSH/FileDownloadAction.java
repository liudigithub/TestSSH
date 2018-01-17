package com.test.TestSSH;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.test.TestSSH.domain.FileModel;
import com.test.TestSSH.service.FileService;

/**
 * 文件下载
 * 
 * @author liudi
 * @date 2018年1月17日
 */
public class FileDownloadAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    
    @Autowired
    private FileService fileService;
    
    private String fileName;
    
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getFileName() throws UnsupportedEncodingException {
        return URLEncoder.encode(fileName, "UTF-8");
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public InputStream getDownloadFile() {
        FileModel file = fileService.get(id);
        fileName = file.getoName();
        InputStream is = ServletActionContext.getServletContext().getResourceAsStream(file.getPath()+"/"+file.getSaveName());
        return is;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
