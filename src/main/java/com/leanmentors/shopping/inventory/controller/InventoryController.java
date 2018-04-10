package com.leanmentors.shopping.inventory.controller;


import com.leanmentors.shopping.inventory.entities.Inventory;
import com.leanmentors.shopping.inventory.services.InventoryService;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/inventory")
@Slf4j
@Setter
public class InventoryController {


    @Autowired
    InventoryService inventoryService;

    @GetMapping("/{code}")
    public ResponseEntity<Inventory> getInventory(@PathVariable String code){
       Optional<Inventory> inventory = inventoryService.findByCode(code);
       if(inventory.isPresent()){
           return new ResponseEntity<Inventory>(inventory.get(), HttpStatus.OK);
       }else{
           return new ResponseEntity(HttpStatus.NOT_FOUND);
       }
    }

}
