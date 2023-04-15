package com.imagegallery.store.Model;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
@Repository
@Entity
@Table(name = "imagestore")
public class ImageInfo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "imagename")
    private String imagename;
    @Column(name = "imagetitle")
    private String imagetitle;
    @Column(name = "imagedescription")
    private String imagedescription;
    @Column(name = "useremail")
    private String useremail;

    public ImageInfo(String imagename, String imagetitle, String imagedescription, String useremail) {
        this.imagename = imagename;
        this.imagetitle = imagetitle;
        this.imagedescription = imagedescription;
        this.useremail = useremail;
    }

    public ImageInfo() {
    }

    public ImageInfo(MultipartFile imagename, String imagetitle, String imagedescription, String useremail) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
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
        return "ImageInfo{" +
                "id=" + id +
                ", imagename='" + imagename + '\'' +
                ", imagetitle='" + imagetitle + '\'' +
                ", imagedescription='" + imagedescription + '\'' +
                ", useremail='" + useremail + '\'' +
                '}';
    }
}
