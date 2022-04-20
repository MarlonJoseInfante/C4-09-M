package com.ecommerce.changuito.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "merchandiser")
@SQLDelete(sql = "UPDATE merchandiser SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MerchandiserEntity extends BaseEntity{

    @NotBlank(message = "Name is a mandatory field")
    private String name;

    @NotBlank(message = "Lastname is a mandatory field")
    private String lastname;

    private String description;

    @Column(length = 11)
    private String cuit;

    //TODO: agregar relación con la city
    private String street;

    @Column(name = "street_number")
    private String streetNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private UserEntity user;

    @Column(name="update_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate updateDate;

    @Column(name = "creation_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @CreationTimestamp
    private LocalDate creationDate ;

}