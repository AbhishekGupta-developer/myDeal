package com.myorganisation.mydeal.service;

import com.myorganisation.mydeal.dto.ProductInputDto;
import com.myorganisation.mydeal.dto.ProductOutputDto;

import java.util.List;

public interface ProductService {

    ProductOutputDto addProduct(ProductInputDto productInputDto);
    ProductOutputDto getProduct(Long id);
    List<ProductOutputDto> getAllProducts();
    ProductOutputDto updateProduct(Long id, ProductInputDto productInputDto);
    String removeProduct(Long id);
}
