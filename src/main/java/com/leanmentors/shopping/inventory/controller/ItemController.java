package com.leanmentors.shopping.inventory.controller;


import com.leanmentors.shopping.inventory.entities.Item;
import com.leanmentors.shopping.inventory.services.ItemService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
@Slf4j
@Data
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("")
    public List<Item> getItems(){
        return itemService.findAll();
    }

    @GetMapping("/{code}")
    public ResponseEntity<Item> getItem(@PathVariable String code){
        Optional<Item> item = itemService.findByCode(code);
        if(item.isPresent()){
            return new ResponseEntity<Item>(item.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
