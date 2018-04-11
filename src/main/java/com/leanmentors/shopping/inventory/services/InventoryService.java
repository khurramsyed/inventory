package com.leanmentors.shopping.inventory.services;

import com.leanmentors.shopping.inventory.entities.Inventory;
import com.leanmentors.shopping.inventory.repositories.InventoryRepository;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@Slf4j
@Setter
public class InventoryService {

    @Autowired
    InventoryRepository repository;


    public Optional<Inventory> findByCode(String code){
        return  repository.findByCode(code);

    }

}
