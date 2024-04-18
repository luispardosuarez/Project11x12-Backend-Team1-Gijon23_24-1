package com.x12.project11x12.prices;

import jakarta.persistence.*;

@Entity
@Table(name = "prices")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_price")
    private Long id;

    @Column(name = "service")
    private String service;

    @Column(name = "price")
    private long priceInCents;

    public Price() {
    }

    public Price(String service, long priceInCents) {
        this.service = service;
        this.priceInCents = priceInCents;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public long getPriceInCents() {
        return priceInCents;
    }

    public void setPriceInCents(long priceInCents) {
        this.priceInCents = priceInCents;
    }
}
