package com.leanmentors.shopping.inventory.entities;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long quantity;

    private String description;

}
