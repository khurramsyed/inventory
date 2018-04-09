package com.leanmentors.shopping.inventory.entities;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "Items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;
    private String description;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private Long inventory_id;


}