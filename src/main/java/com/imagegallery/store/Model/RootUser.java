package com.imagegallery.store.Model;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.swing.*;
import java.sql.Blob;
import java.util.Date;

@Entity
@Table(name = "rootuser")
//model is the domain object name
public class RootUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rootid")
    private Long rootid;
    @Column(name = "rootusername", length = 30)
    private String rootusername;
    @Column(name = "rootemail", length = 100)
    private String rootemail;
    @Column(name = "rootpassword", length = 3000)
    private String rootpassword;
    @Column(name = "rootmobilenumber", length = 30)
    private String rootmobilenumber;
    @Column(name = "rootaddress", length = 30)
    private String rootaddress;
    @Lob
    private String rootimage;
    private Date rootdate = new Date();

    public RootUser() {
    }
    public RootUser(String rootusername, String rootemail, String rootpassword,
                    String rootmobilenumber, String rootaddress,String rootimage){
        this.rootusername = rootusername;
        this.rootemail = rootemail;
        this.rootpassword = rootpassword;
        this.rootmobilenumber = rootmobilenumber;
        this.rootaddress = rootaddress;
        this.rootimage = rootimage;
    }
    public Long getRootid() {
        return rootid;
    }

    public void setRootid(Long rootid) {
        this.rootid = rootid;
    }

    public String getRootusername() {
        return rootusername;
    }

    public void setRootusername(String rootusername) {
        this.rootusername = rootusername;
    }

    public String getRootemail() {
        return rootemail;
    }

    public void setRootemail(String rootemail) {
        this.rootemail = rootemail;
    }

    public String getRootpassword() {
        return rootpassword;
    }

    public void setRootpassword(String rootpassword) {
        this.rootpassword = rootpassword;
    }

    public String getRootmobilenumber() {
        return rootmobilenumber;
    }

    public void setRootmobilenumber(String rootmobilenumber) {
        this.rootmobilenumber = rootmobilenumber;
    }

    public String getRootaddress() {
        return rootaddress;
    }

    public void setRootaddress(String rootaddress) {
        this.rootaddress = rootaddress;
    }

    public String getRootimage() {
        return rootimage;
    }

    public void setRootimage(String rootimage) {
        this.rootimage = rootimage;
    }

    public Date getRootdate() {
        return rootdate;
    }

    public void setRootdate(Date rootdate) {
        this.rootdate = rootdate;
    }

    @Override
    public String toString() {
        return "RootUser{" +
                "rootid=" + rootid +
                ", rootusername='" + rootusername + '\'' +
                ", rootemail='" + rootemail + '\'' +
                ", rootpassword='" + rootpassword + '\'' +
                ", rootmobilenumber='" + rootmobilenumber + '\'' +
                ", rootaddress='" + rootaddress + '\'' +
                ", rootimage='" + rootimage + '\'' +
                ", rootdate=" + rootdate +
                '}';
    }
}