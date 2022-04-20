package com.ecommerce.changuito.entity;

import com.ecommerce.changuito.utils.EnumStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cart")
@SQLDelete(sql = "UPDATE cart SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CartEntity extends BaseEntity {
   @Column(name = "status", nullable = false, updatable = true)
   @Enumerated(value = EnumType.STRING)
   private EnumStatus enumStatus;

   private String ticket;

   @Column(name = "id_cliente", nullable = false, updatable=true)
   private Integer clienteId;

   @Column(name = "id_merchandiser", nullable = false, updatable=true)
   private Integer merchandiserId;

   @Column(name="update_date")
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private LocalDateTime updateDate;

   @Column(name = "creation_date")
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private LocalDateTime creationDate = LocalDateTime.now();

   @JsonIgnore
   @ManyToMany(mappedBy = "carts")
   private Set<Product> products = new HashSet<Product>();

   //@JsonIgnore
   //@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  // private List<Product> products = new ArrayList<>();

   //@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
   //@JoinColumn(name = "id_merchandiser")
   //private MerchandiserEntity merchandiser;

 //  @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
  // @JoinColumn(name = "id_cliente", nullable = false, updatable=true)
  // private ClienteEntity cliente;

}
