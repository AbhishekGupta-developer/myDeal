package com.myorganisation.mydeal.dto;

import com.myorganisation.mydeal.model.Cart;
import lombok.Data;

@Data
public class UserOutputDto {
    private Long id;
    private String name;
    private Cart cart;
}
