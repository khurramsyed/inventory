package com.leanmentors.shopping.inventory.controller;


import com.leanmentors.shopping.inventory.entities.Item;
import com.leanmentors.shopping.inventory.services.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
@Slf4j
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("")
    public List<Item> getItems(){
        return itemService.findAll();
    }

    @GetMapping("/{code}")
    public Optional<Item> getItem(@PathVariable String code){
        return itemService.findByCode(code);
    }

}
