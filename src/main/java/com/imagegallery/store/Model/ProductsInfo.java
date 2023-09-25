package com.imagegallery.store.Model;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Date;
import java.lang.Long;
//productinfo model used to upload product to a particular category.
@Repository
@Entity
@Table(name = "products")
public class ProductsInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Lob
    private String image;
    @Column(name = "price")
    private String price;
    @Column(name = "buyprice")
    private String buyprice;
    @Column(name = "quantity")
    private String quantity;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    private String status;
    @Column(name = "date")
    private Date date = new Date();
    @Column(name = "category")
    private String category;
    @Column(name = "email")
    private String email;

    public ProductsInfo() {
    }

    public ProductsInfo(Long id, String name, String image, String price, String buyprice, String description, String status) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.buyprice = buyprice;
        this.description = description;
        this.status = status;
    }
    public ProductsInfo( String name, String image, String price, String buyprice, String quantity, String description, String status, String category, String email) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.buyprice = buyprice;
        this.quantity = quantity;
        this.description = description;
        this.status = status;
        this.category = category;
        this.email = email;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBuyprice() {
        return buyprice;
    }

    public void setBuyprice(String buyprice) {
        this.buyprice = buyprice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ProductsInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image=" + image +
                ", price='" + price + '\'' +
                ", buyprice='" + buyprice + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                ", category='" + category + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
