package com.imagegallery.store.DTO;

import org.springframework.web.multipart.MultipartFile;

public class ImageStoreDTO {
    Long id;
    MultipartFile imagename;
    String imagetitle;
    String imagedescription;
    String useremail;

    public ImageStoreDTO(Long id, MultipartFile imagename, String imagetitle, String imagedescription, String useremail) {
        this.id = id;
        this.imagename = imagename;
        this.imagetitle = imagetitle;
        this.imagedescription = imagedescription;
        this.useremail = useremail;
    }

    public ImageStoreDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MultipartFile getImagename() {
        return imagename;
    }

    public void setImagename(MultipartFile imagename) {
        this.imagename = imagename;
    }

    public String getImagetitle() {
        return imagetitle;
    }

    public void setImagetitle(String imagetitle) {
        this.imagetitle = imagetitle;
    }

    public String getImagedescription() {
        return imagedescription;
    }

    public void setImagedescription(String imagedescription) {
        this.imagedescription = imagedescription;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    @Override
    public String toString() {
        return "ImageStoreDTO{" +
                "id=" + id +
                ", imagename=" + imagename +
                ", imagetitle='" + imagetitle + '\'' +
                ", imagedescription='" + imagedescription + '\'' +
                ", useremail='" + useremail + '\'' +
                '}';
    }
}
