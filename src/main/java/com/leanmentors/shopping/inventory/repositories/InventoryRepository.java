package com.leanmentors.shopping.inventory.repositories;

import com.leanmentors.shopping.inventory.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    @Query("select inventory from Inventory inventory JOIN Item item on inventory.id=item.inventory_id" +
            " AND item.code = :code ")
    Optional<Inventory> findByCode(@Param("code")  String code);


}
