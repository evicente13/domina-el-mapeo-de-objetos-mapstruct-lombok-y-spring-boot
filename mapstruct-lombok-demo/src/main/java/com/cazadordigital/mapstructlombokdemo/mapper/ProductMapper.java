package com.cazadordigital.mapstructlombokdemo.mapper;

import com.cazadordigital.mapstructlombokdemo.dto.GetProduct;
import com.cazadordigital.mapstructlombokdemo.entity.Product;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    @Mappings({
        @Mapping(source = "creationDate", target = "creationDate",
                dateFormat = "yyyy-MM-dd HH:mm:ss")
    })

    GetProduct toGetDTO(Product product);

    @InheritInverseConfiguration
    Product toEntity(GetProduct getProduct);
}
