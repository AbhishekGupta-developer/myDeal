package com.myorganisation.mydeal.dto;

import com.myorganisation.mydeal.enums.Category;
import lombok.Data;

@Data
public class ProductOutputDto {
    private Long id;
    private String name;
    private Category category;
}
