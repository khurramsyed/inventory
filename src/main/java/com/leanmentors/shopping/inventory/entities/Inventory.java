package com.leanmentors.shopping.inventory.entities;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long productId;

    private Long quantity;

    @OneToOne(mappedBy = "inventory")
    private Item item;

}
