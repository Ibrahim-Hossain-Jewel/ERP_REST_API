package com.imagegallery.store.Controller;
import com.imagegallery.store.Model.OrderTable;
import com.imagegallery.store.Model.ProductsInfo;
import com.imagegallery.store.Repo.OrderRepo;
import com.imagegallery.store.Repo.ProductRepo;
import com.imagegallery.store.Response.ProductsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    OrderRepo orderRepo;
    // add products - post
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/addproducts")
    public ProductsResponse addProducts(HttpServletRequest request,
                                        @RequestParam("name") String name,
                                        @RequestParam("image") MultipartFile file,
                                        @RequestParam("price") String price,
                                        @RequestParam("buyprice") String buyprice,
                                        @RequestParam("description") String description,
                                        @RequestParam("status") String status,
                                        @RequestParam("category") String category,
                                        @RequestParam("email") String email
    ) throws IOException, SerialException, SQLException
    {
        byte[] bytes = file.getBytes();
        String encodedString = Base64
                .getEncoder()
                .encodeToString(bytes);
        System.out.println("image encoded to the array " + encodedString);
        ProductsInfo addProducts = new ProductsInfo(
                name,
                encodedString,
                price,
                buyprice,
                description,
                status,
                category,
                email
        );
        productRepo.save(addProducts);
        return new ProductsResponse("Product Uploaded!", true);
    }
    //fetch all products
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/allproductinfo")
    public ResponseEntity<?> productinfo() throws IOException {
        List<ProductsInfo> fileResponse = productRepo.findAll();
        return ResponseEntity.ok(fileResponse);
    }

    //Confirm order
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/placeorder")
    public ProductsResponse placeorder(HttpServletRequest request,
                                        @RequestParam("customername") String customername,
                                        @RequestParam("customerphonenumber") String customerphonenumber,
                                        @RequestParam("customeraddress") String customeraddress,
                                        @RequestParam("customeremail") String customeremail,
                                        @RequestParam("productid") String productid,
                                        @RequestParam("productname") String productname,
                                        @RequestParam("productimage") String productimage,
                                        @RequestParam("productprice") String productprice,
                                        @RequestParam("buyprice") String buyprice,
                                        @RequestParam("productdescription") String productdescription,
                                        @RequestParam("productstatus") String productstatus,
                                        @RequestParam("productcategory") String productcategory,
                                        @RequestParam("uploaderemail") String uploaderemail,
                                        @RequestParam("customercomment") String customercomment,
                                        @RequestParam("productquantity") String productquantity,
                                        @RequestParam("totalamount") String totalamount,
                                       @RequestParam("paymentmethod") String paymentmethod,
                                       @RequestParam("orderstatus") String orderstatus
    ) throws IOException, SerialException, SQLException
    {
        OrderTable addOrder = new OrderTable(
                customername,
                customerphonenumber,
                customeraddress,
                customeremail,
                productid,
                productname,
                productimage,
                productprice,
                buyprice,
                productdescription,
                productstatus,
                productcategory,
                uploaderemail,
                customercomment,
                productquantity,
                totalamount,
                paymentmethod,
                orderstatus
        );
        orderRepo.save(addOrder);
        return new ProductsResponse("Order confirmed! Please wait calling soon!", true);
    }
    //for authenticated users
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/orderlist")
    public ResponseEntity<?> orderlist(@RequestParam("customeremail") String customeremail) {
        List<OrderTable> fileResponse = orderRepo.findOneByEmail(customeremail);
        return ResponseEntity.ok(fileResponse);
    }
    //delete order
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(value = "/delete/{id}")
    public ProductsResponse deleteUser(@PathVariable long id){
        OrderTable deleteUser = orderRepo.findById(id).get();
        orderRepo.delete(deleteUser);
        return new ProductsResponse("Delete success", true);
    }
    //All order list;
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/allproductorderlist")
    public ResponseEntity<?> allOrderedProduct() throws IOException {
        List<OrderTable> fileResponse = orderRepo.findAll();
        return ResponseEntity.ok(fileResponse);
    }
    //todays order list by filter.
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/allproductorderlistbydate")
    public ResponseEntity<?> allOrderedProductbydate() throws IOException {
//        Instant orderdatetoday = new Date().toInstant(); @RequestParam("date") String date
//        Date orderdatetoday = new Date();
        LocalDate orderdatetoday = LocalDate.now();
        System.out.println("date,,,,,,"+ orderdatetoday);
        List<OrderTable> fileResponse = orderRepo.findByorderdate(orderdatetoday);
        return ResponseEntity.ok(fileResponse);
    }
    //Selected order date list
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/selectorderlistbytodatefromdate")
    public ResponseEntity<?> allOrderedProductbyTodateFromDate(@RequestParam("fromdate") String fromdate,
        @RequestParam("todate") String todate) throws IOException {
        System.out.println("date,,,,,,"+ fromdate + todate);
        List<OrderTable> fileResponse = orderRepo.findByorderdate(fromdate, todate);
        return ResponseEntity.ok(fileResponse);
    }
}
