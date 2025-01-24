package com.myorganisation.mydeal.controller;

import com.myorganisation.mydeal.dto.ProductInputDto;
import com.myorganisation.mydeal.dto.ProductOutputDto;
import com.myorganisation.mydeal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<ProductOutputDto> addProduct(@RequestBody ProductInputDto productInputDto) {
        return new ResponseEntity<>(productService.addProduct(productInputDto), HttpStatusCode.valueOf(201));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductOutputDto> getProduct(@PathVariable Long id) {
        return new ResponseEntity<>(productService.getProduct(id), HttpStatusCode.valueOf(200));
    }

    @GetMapping
    public ResponseEntity<List<ProductOutputDto>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatusCode.valueOf(200));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductOutputDto> updateProduct(@PathVariable Long id, @RequestBody ProductInputDto productInputDto) {
        return new ResponseEntity<>(productService.updateProduct(id, productInputDto), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping
    public ResponseEntity<String> removeProduct(@RequestParam Long id) {
        return new ResponseEntity<>(productService.removeProduct(id), HttpStatusCode.valueOf(200));
    }
}
