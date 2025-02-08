package com.myorganisation.mydeal.service;

import com.myorganisation.mydeal.dto.ProductInputDto;
import com.myorganisation.mydeal.dto.ProductOutputDto;
import com.myorganisation.mydeal.model.Product;
import com.myorganisation.mydeal.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductOutputDto addProduct(ProductInputDto productInputDto) {
        Product product = new Product();

        product.setName(productInputDto.getName());
        product.setCategory(productInputDto.getCategory());

        product = productRepository.save(product);

        ProductOutputDto productOutputDto = new ProductOutputDto();

        productOutputDto.setId(product.getId());
        productOutputDto.setName(product.getName());
        productOutputDto.setCategory(product.getCategory());

        return productOutputDto;
    }

    @Override
    public ProductOutputDto getProduct(Long id) {
        Product product = productRepository.findById(id).orElse(null);

        ProductOutputDto productOutputDto = new ProductOutputDto();

        productOutputDto.setId(product.getId());
        productOutputDto.setName(product.getName());
        productOutputDto.setCategory(product.getCategory());

        return productOutputDto;
    }

    @Override
    public List<ProductOutputDto> getAllProducts() {
        List<Product> productList = productRepository.findAll(); //10 sec

        List<ProductOutputDto> productOutputDtoList = new ArrayList<>(); //2 sec

        //12 sec -> //10 sec
        for(Product product : productList) {
            ProductOutputDto productOutputDto = new ProductOutputDto();

            productOutputDto.setId(product.getId());
            productOutputDto.setName(product.getName());
            productOutputDto.setCategory(product.getCategory());

            productOutputDtoList.add(productOutputDto);
        }

        return productOutputDtoList;
    }

    @Override
    public ProductOutputDto updateProduct(Long id, ProductInputDto productInputDto) {
        Product product = new Product();

        product.setId(id);
        product.setName(productInputDto.getName());
        product.setCategory(productInputDto.getCategory());

        product = productRepository.save(product);

        ProductOutputDto productOutputDto = new ProductOutputDto();

        productOutputDto.setId(product.getId());
        productOutputDto.setName(product.getName());
        productOutputDto.setCategory(product.getCategory());

        return productOutputDto;
    }

    @Override
    public String removeProduct(Long id) {
        String name = productRepository.findById(id).orElse(null).getName();

        productRepository.deleteById(id);
        return "Product name: " + name + "(" + id + ") removed successfully!";
    }
}
