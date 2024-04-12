package com.x12.project11x12.discounts;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class DiscountService {

    private final DiscountRepository discountRepository;

    @Autowired
    public DiscountService(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    public List<Discount> getAllDiscounts() {
        return discountRepository.findAll();
    }

    public Discount createDiscount(Discount discount) {
        return discountRepository.save(discount);
    }

    public Discount getDiscountById(Long id) {
        return discountRepository.findById(id).orElse(null);
    }

    public Discount updateDiscount(Long id, Discount discountDetails) {
        Discount discount = discountRepository.findById(id).orElse(null);
        if (discount == null) {
            return null;
        }
        discount.setFoodId(discountDetails.getFoodId());
        discount.setDiscountName(discountDetails.getDiscountName());
        discount.setDiscountImport(discountDetails.getDiscountImport());
        return discountRepository.save(discount);
    }

    public void deleteDiscount(Long id) {
        discountRepository.deleteById(id);
    }
}

