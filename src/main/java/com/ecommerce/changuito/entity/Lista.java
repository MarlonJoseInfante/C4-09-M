package com.ecommerce.changuito.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

@Entity
@Table(name="product")
@SQLDelete(sql = "UPDATE product SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Data
public class Lista extends BaseEntity{

private Integer idTicket;
private Integer idproduct;
private Integer quantity;
    
}
