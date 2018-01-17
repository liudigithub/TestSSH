package com.test.TestSSH;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.test.TestSSH.domain.FileModel;
import com.test.TestSSH.service.FileService;

/**
 * 
 * 
 * @author liudi
 * @date 2018年1月17日
 */
public class FileAction extends ActionSupport {
    private static final long serialVersionUID = 1L;

    @Autowired
    private FileService fileService;

    // 注意，file并不是指前端jsp上传过来的文件本身，而是文件上传过来存放在临时文件夹下面的文件
    private File file;

    // 提交过来的file的名字
    private String fileFileName;

    // 提交过来的file的MIME类型
    private String fileContentType;

    List<FileModel> fileImgslist;


    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = System.currentTimeMillis() + fileFileName;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }



    public List<FileModel> getFileImgslist() {
        return fileImgslist;
    }

    public void setFileImgslist(List<FileModel> fileImgslist) {
        this.fileImgslist = fileImgslist;
    }

    public String execute() throws IOException {
        // 上传路径
        String savePath = "upload";
        // 服务器路径
        String root = ServletActionContext.getServletContext().getRealPath("/"+savePath);

        // 文件路径创建
        File filePath = new File(root);
        if (!filePath.exists()) {
            filePath.mkdirs();
        }

        // 获取扩展名
        String suffix = fileFileName.substring(fileFileName.lastIndexOf(".") + 1);
        // 保存文件名
        Date now = Calendar.getInstance().getTime();
        String saveName = now.getTime() + "." + suffix;

        // 创建输入流
        InputStream is = new FileInputStream(file);
        // 创建输出流
        OutputStream os = new FileOutputStream(new File(root, saveName));

        // 信息保存到库
        FileModel entity = new FileModel();
        entity.setoName(fileFileName.substring(13));
        entity.setSaveName(saveName);
        entity.setPath(savePath);
        entity.setCreateTime(now);
        fileService.save(entity);

        // 图片上传
        byte[] buffer = new byte[500];
        while (-1 != (is.read(buffer, 0, buffer.length))) {
            os.write(buffer);
        }

        os.close();
        is.close();

        return SUCCESS;
    }

    public String list() {
        // 将数据库中的值保存到list集合中
        fileImgslist = fileService.findAll();
        return SUCCESS;
    }
    
}
