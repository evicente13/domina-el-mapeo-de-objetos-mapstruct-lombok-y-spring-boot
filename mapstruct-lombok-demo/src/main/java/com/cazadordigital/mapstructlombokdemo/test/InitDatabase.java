package com.cazadordigital.mapstructlombokdemo.test;

import com.cazadordigital.mapstructlombokdemo.dto.GetProduct;
import com.cazadordigital.mapstructlombokdemo.entity.Product;
import com.cazadordigital.mapstructlombokdemo.mapper.ProductMapper;
import com.cazadordigital.mapstructlombokdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class InitDatabase {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Bean
    public CommandLineRunner testProductMapperCommand(){
        return args -> {
            List<Product> products = productRepository.findAll();

            System.out.println("PRODUCTS");
            products.forEach(System.out::println);
            //products.forEach(product -> System.out.println(product));

            System.out.println("GET PRODUCT");
            List<GetProduct> getProductList = products
                    .stream().map(product -> productMapper.toGetDTO(product))
                    .peek(System.out::println)
                    .collect(Collectors.toList());

        };
    }
}
