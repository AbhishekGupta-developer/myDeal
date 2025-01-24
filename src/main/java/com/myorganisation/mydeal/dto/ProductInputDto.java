package com.myorganisation.mydeal.dto;

import com.myorganisation.mydeal.enums.Category;
import lombok.Data;

@Data
public class ProductInputDto {
    private String name;
    private Category category;
}
