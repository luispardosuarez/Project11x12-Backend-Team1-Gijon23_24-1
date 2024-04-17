package com.x12.project11x12.prices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "${api-endpoint}/prices")
public class PriceController {

    private final PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    public ResponseEntity<List<Price>> getAllPrices() {
        List<Price> prices = priceService.getAllPrices();
        return new ResponseEntity<>(prices, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Price> createPrice(@RequestBody Price price) {
        Price createdPrice = priceService.createPrice(price);
        return new ResponseEntity<>(createdPrice, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Price> updatePrice(@PathVariable("id") Long id, @RequestBody Price price) {
        Price updatedPrice = priceService.updatePrice(id, price);
        if (updatedPrice == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedPrice, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePrice(@PathVariable("id") Long id) {
        priceService.deletePrice(id);
        return ResponseEntity.ok("Price deleted successfully");
    }
}
