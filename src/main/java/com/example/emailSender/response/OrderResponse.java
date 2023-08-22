package com.example.emailSender.response;
public class OrderResponse {
    private String customerId;
    private String storeId;
    private Long orderId;
    private String details;
    private Double price;
    private String orderStatus;

    public String getCustomerId() {
        return customerId;
    }

    public String getStoreId() {
        return storeId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getDetails() {
        return details;
    }

    public Double getPrice() {
        return price;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
