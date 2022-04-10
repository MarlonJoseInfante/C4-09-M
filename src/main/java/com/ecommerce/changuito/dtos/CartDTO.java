package com.ecommerce.changuito.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import com.ecommerce.changuito.entities.ClienteEntity;
import com.ecommerce.changuito.entities.Lista;
import com.ecommerce.changuito.entities.Product;
import com.ecommerce.changuito.utils.EnumStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data


public class CartDTO {

    private Long id;

    private EnumStatus status;

    private String ticket;   

    private LocalDateTime updateDate;

    private LocalDateTime creationDate;

    private Integer merchandiserId;

    private Integer clienteId;

    private Set<Product> products;

    }
    
//    private <List> product;


