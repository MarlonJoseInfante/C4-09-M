package com.ecommerce.changuito.services;

import java.util.List;

import com.ecommerce.changuito.dtos.CartDetailsDTO;



public interface CartDetailsService {
    CartDetailsDTO add(CartDetailsDTO dto);
    List<CartDetailsDTO> getAll();
    
}
