package com.kris.managedbeans;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
 
@ManagedBean(name="fileUploadBean")
@RequestScoped
 
public class FileUploadManagedBean implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    private String name;
    private UploadedFile resume;
 
    public UploadedFile getResume() {
        return resume;
    }
 
    public void setResume(UploadedFile resume) {
        this.resume = resume;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
 
    /*  The above code is for file upload using simple mode. */
 
    //This below code is for file upload with advanced mode.
 
    public void uploadPhoto(FileUploadEvent e) throws IOException{
 
        UploadedFile uploadedPhoto=e.getFile();
 
        String filePath="C:\\Users\\Kris\\Desktop\\albums";
        byte[] bytes=null;
 
            if (null!=uploadedPhoto) {
                bytes = uploadedPhoto.getContents();
                String filename = FilenameUtils.getName(uploadedPhoto.getFileName());
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath+filename)));
                stream.write(bytes);
                stream.close();
            }
 
        FacesContext.getCurrentInstance().addMessage("messages",new FacesMessage(FacesMessage.SEVERITY_INFO,"Your Photo (File Name "+ uploadedPhoto.getFileName()+ " with size "+ uploadedPhoto.getSize()+ ")  Uploaded Successfully", ""));
    }
 
}