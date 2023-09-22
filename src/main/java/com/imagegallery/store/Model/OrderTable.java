package com.imagegallery.store.Model;
import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;

@Entity
@Table(name = "ordertable")
public class OrderTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid")
    private long orderid;
    @Column(name = "customername")
    private String customername;
    @Column(name = "customerphonenumber")
    private String customerphonenumber;
    @Column(name = "customeraddress")
    private String customeraddress;
    @Column(name = "customeremail")
    private String customeremail;
    @Column(name = "productid")
    private String productid;
    @Column(name = "productname")
    private String productname;
    @Lob
    private String productimage;
    @Column(name = "productprice")
    private String productprice;
    @Column(name = "buyprice")
    private String buyprice;
    @Column(name = "productdescription")
    private String productdescription;
    @Column(name = "productstatus")
    private String productstatus;
    @Column(name = "orderdate")
    private Date orderdate = new Date();
    @Column(name = "productcategory")
    private String productcategory;
    @Column(name = "uploaderemail")
    private String uploaderemail;
    @Column(name = "customercomment")
    private String customercomment;
    @Column(name = "productquantity")
    private String productquantiy;
    @Column(name = "totalamount")
    private String totalamount;
    @Column(name = "paymentmethod")
    private String paymentmethod;
    @Column(name = "orderstatus")
    private String orderstatus;

    public OrderTable() {
    }

    public OrderTable(String customername,
                      String customerphonenumber,
                      String customeraddress,
                      String customeremail,
                      String productid,
                      String productname,
                      String productimage,
                      String productprice,
                      String buyprice,
                      String productdescription,
                      String productstatus,
                      String productcategory,
                      String uploaderemail,
                      String customercomment,
                      String productquantiy,
                      String totalamount,
                      String paymentmethod,
                      String orderstatus
    ) {
        this.customername = customername;
        this.customerphonenumber = customerphonenumber;
        this.customeraddress = customeraddress;
        this.customeremail = customeremail;
        this.productid = productid;
        this.productname = productname;
        this.productimage = productimage;
        this.productprice = productprice;
        this.buyprice = buyprice;
        this.productdescription = productdescription;
        this.productstatus = productstatus;
        this.productcategory = productcategory;
        this.uploaderemail = uploaderemail;
        this.customercomment = customercomment;
        this.productquantiy = productquantiy;
        this.totalamount = totalamount;
        this.paymentmethod = paymentmethod;
        this.orderstatus = orderstatus;
    }

    public String getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public String getCustomercomment() {
        return customercomment;
    }

    public void setCustomercomment(String customercomment) {
        this.customercomment = customercomment;
    }

    public String getProductquantiy() {
        return productquantiy;
    }

    public void setProductquantiy(String productquantiy) {
        this.productquantiy = productquantiy;
    }

    public String getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(String totalamount) {
        this.totalamount = totalamount;
    }

    public long getOrderid() {
        return orderid;
    }

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCustomerphonenumber() {
        return customerphonenumber;
    }

    public void setCustomerphonenumber(String customerphonenumber) {
        this.customerphonenumber = customerphonenumber;
    }

    public String getCustomeraddress() {
        return customeraddress;
    }

    public void setCustomeraddress(String customeraddress) {
        this.customeraddress = customeraddress;
    }

    public String getCustomeremail() {
        return customeremail;
    }

    public void setCustomeremail(String customeremail) {
        this.customeremail = customeremail;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductimage() {
        return productimage;
    }

    public void setProductimage(String productimage) {
        this.productimage = productimage;
    }

    public String getProductprice() {
        return productprice;
    }

    public void setProductprice(String productprice) {
        this.productprice = productprice;
    }

    public String getBuyprice() {
        return buyprice;
    }

    public void setBuyprice(String buyprice) {
        this.buyprice = buyprice;
    }

    public String getProductdescription() {
        return productdescription;
    }

    public void setProductdescription(String productdescription) {
        this.productdescription = productdescription;
    }

    public String getProductstatus() {
        return productstatus;
    }

    public void setProductstatus(String productstatus) {
        this.productstatus = productstatus;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public String getProductcategory() {
        return productcategory;
    }

    public void setProductcategory(String productcategory) {
        this.productcategory = productcategory;
    }

    public String getUploaderemail() {
        return uploaderemail;
    }

    public void setUploaderemail(String uploaderemail) {
        this.uploaderemail = uploaderemail;
    }

    @Override
    public String toString() {
        return "OrderTable{" +
                "orderid=" + orderid +
                ", customername='" + customername + '\'' +
                ", customerphonenumber='" + customerphonenumber + '\'' +
                ", customeraddress='" + customeraddress + '\'' +
                ", customeremail='" + customeremail + '\'' +
                ", productid='" + productid + '\'' +
                ", productname='" + productname + '\'' +
                ", productimage='" + productimage + '\'' +
                ", productprice='" + productprice + '\'' +
                ", productdescription='" + productdescription + '\'' +
                ", productstatus='" + productstatus + '\'' +
                ", orderdate=" + orderdate +
                ", productcategory='" + productcategory + '\'' +
                ", uploaderemail='" + uploaderemail + '\'' +
                ", customercomment='" + customercomment + '\'' +
                ", productquantiy='" + productquantiy + '\'' +
                ", totalamount='" + totalamount + '\'' +
                '}';
    }
}
