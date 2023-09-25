package com.imagegallery.store.DTO;

public class UpdateOrderStatusDTO {
    private long orderid;
    private String orderstatus;
    private String productquantiy;

    public UpdateOrderStatusDTO() {
    }

    public UpdateOrderStatusDTO(long orderid, String orderstatus) {
        this.orderid = orderid;
        this.orderstatus = orderstatus;
    }

    public String getProductquantiy() {
        return productquantiy;
    }

    public void setProductquantiy(String productquantiy) {
        this.productquantiy = productquantiy;
    }

    public long getOrderid() {
        return orderid;
    }

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }

    public String getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus;
    }

    @Override
    public String toString() {
        return "UpdateOrderStatusDTO{" +
                "orderid=" + orderid +
                ", orderstatus='" + orderstatus + '\'' +
                '}';
    }
}
