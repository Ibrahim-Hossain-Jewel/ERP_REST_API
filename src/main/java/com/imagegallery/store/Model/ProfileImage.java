package com.imagegallery.store.Model;
import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "user")
public class ProfileImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userid;
    @Lob
    private Blob profilepicture;

    public ProfileImage() {
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public Blob getProfilepicture() {
        return profilepicture;
    }

    public void setProfilepicture(Blob profilepicture) {
        this.profilepicture = profilepicture;
    }

    @Override
    public String toString() {
        return "ProfileImage{" +
                "userid=" + userid +
                ", profilepicture=" + profilepicture +
                '}';
    }
}
