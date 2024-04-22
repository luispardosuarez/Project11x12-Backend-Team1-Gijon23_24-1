package com.x12.project11x12.payments;

public class PaymentItem {
    
    private Long id;
    private String productName;
    private Long price;

    public PaymentItem() {
    }    

    public PaymentItem(Long id, String productName, Long price) {
        this.id = id;
        this.productName = productName;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PaymentItem{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }

}
