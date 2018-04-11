package com.leanmentors.shopping.inventory.services;

import com.leanmentors.shopping.inventory.entities.Inventory;
import com.leanmentors.shopping.inventory.entities.Item;
import com.leanmentors.shopping.inventory.repositories.InventoryRepository;
import org.junit.Before;
import org.junit.Test;

import javax.swing.text.html.Option;
import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class InventoryServiceTest {


    InventoryRepository inventoryRepository;
    InventoryService inventoryService;

    @Before
    public void setup() {
        inventoryRepository = mock(InventoryRepository.class);
        inventoryService = new InventoryService();
        inventoryService.setRepository(inventoryRepository);
    }

    @Test
    public void testThatNothingIsReceivedIfRepositoryIsEmpty(){

        when(inventoryRepository.findByCode(anyString())).thenReturn(Optional.empty());
        Optional<Inventory> inventory = inventoryService.findByCode("TheCode");
        assertFalse(inventory.isPresent());
        verify(inventoryRepository, times(1)).findByCode("TheCode");
    }

}
