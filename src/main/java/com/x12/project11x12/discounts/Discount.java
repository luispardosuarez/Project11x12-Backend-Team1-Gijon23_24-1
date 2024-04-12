package com.x12.project11x12.discounts;

import jakarta.persistence.*;


@Entity
@Table(name = "discounts")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_discount")
    private Long id;

    @Column(name = "id_food")
    private Long foodId;

    @Column(name = "discount_name")
    private String discountName;

    @Column(name = "discount_import")
    private double discountImport;

    public Discount() {
    }

    public Discount(Long foodId, String discountName, double discountImport) {
        this.foodId = foodId;
        this.discountName = discountName;
        this.discountImport = discountImport;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public double getDiscountImport() {
        return discountImport;
    }

    public void setDiscountImport(double discountImport) {
        this.discountImport = discountImport;
    }
}
