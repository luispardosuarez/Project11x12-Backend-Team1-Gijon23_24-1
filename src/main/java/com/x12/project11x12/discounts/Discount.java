package com.x12.project11x12.discounts;

import jakarta.persistence.*;

@Entity
@Table(name = "discounts")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_discount")
    private Long id;

    @Column(name = "discount_name")
    private String discountName;

    @Column(name = "discount_import")
    private long discountImport;

    public Discount() {
    }

    public Discount(String discountName, long discountImport) { 
        this.discountName = discountName;
        this.discountImport = discountImport;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public long getDiscountImport() {
        return discountImport;
    }

    public void setDiscountImport(long discountImport) {
        this.discountImport = discountImport;
    }
}
