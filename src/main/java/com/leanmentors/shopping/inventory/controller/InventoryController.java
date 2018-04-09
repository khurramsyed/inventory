package com.leanmentors.shopping.inventory.controller;


import com.leanmentors.shopping.inventory.entities.Inventory;
import com.leanmentors.shopping.inventory.services.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/inventory")
@Slf4j
public class InventoryController {


    @Autowired
    InventoryService inventoryService;

    @GetMapping("/{code}")
    public Optional<Inventory> getInventory(@PathVariable String code){
        return inventoryService.findByCode(code);
    }

}
