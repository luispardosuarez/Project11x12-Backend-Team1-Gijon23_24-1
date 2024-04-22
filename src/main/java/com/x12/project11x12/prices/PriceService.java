package com.x12.project11x12.prices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {

    private final PriceRepository priceRepository;

    @Autowired
    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public List<Price> getAllPrices() {
        return priceRepository.findAll();
    }

    public Price createPrice(Price price) {
        return priceRepository.save(price);
    }

    public Price updatePrice(Long id, Price updatedPrice) {
        Price price = priceRepository.findById(id).orElse(null);
        if (price == null) {
            return null;
        }
        price.setService(updatedPrice.getService());
        price.setPriceInCents(updatedPrice.getPriceInCents());
        return priceRepository.save(price);
    }

    public void deletePrice(Long id) {
        priceRepository.deleteById(id);
    }
}

