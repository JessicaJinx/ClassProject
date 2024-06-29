package com.john.bryce.couponsystem2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Company company;
    @Enumerated(EnumType.STRING)
    private  Category Category;
    private  String title;
    private  String description;
    private  Date startDate;
    private  Date endDate;
    private int amount;
    private  double price;
    private  String image;

}
