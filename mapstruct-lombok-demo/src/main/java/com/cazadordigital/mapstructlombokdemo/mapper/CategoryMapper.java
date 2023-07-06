package com.cazadordigital.mapstructlombokdemo.mapper;

import com.cazadordigital.mapstructlombokdemo.dto.GetCategory;
import com.cazadordigital.mapstructlombokdemo.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {

    GetCategory toGetCategory(Category category);

    @InheritInverseConfiguration
    Category toEntity(GetCategory getCategory);

    List<GetCategory> toGetCategoryList(List<Category> categoryList);

    List<Category> toEntityList(List<GetCategory> getCategoryList);
}