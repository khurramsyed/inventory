package com.leanmentors.shopping.inventory.services;


import com.leanmentors.shopping.inventory.entities.Item;
import com.leanmentors.shopping.inventory.repositories.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
@Slf4j
public class ItemService {


    private ItemRepository itemRepository;

    public ItemService(ItemRepository repository){
        this.itemRepository= repository;
    }

    public Optional<Item> fetchByCode(String code){
        return itemRepository.findByCode(code);
    }

    public List<Item> fetchAll(){
        return itemRepository.findAll();
    }

}
