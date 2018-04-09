package com.leanmentors.shopping.inventory.repositories;

import com.leanmentors.shopping.inventory.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository  extends JpaRepository<Item, Long> {

    Optional<Item> findByCode(String code);

}
