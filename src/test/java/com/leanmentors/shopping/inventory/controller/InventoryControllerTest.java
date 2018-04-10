package com.leanmentors.shopping.inventory.controller;

import com.leanmentors.shopping.inventory.entities.Inventory;
import com.leanmentors.shopping.inventory.entities.Item;
import com.leanmentors.shopping.inventory.services.InventoryService;
import com.leanmentors.shopping.inventory.services.ItemService;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class InventoryControllerTest {

    @Test
    public void controllerShouldGetsDataFromService(){

        InventoryController controller = new InventoryController();
        InventoryService service = mock(InventoryService.class);
        controller.setInventoryService(service);
        Inventory inventory = new Inventory();
        inventory.setId(1L);
        when(service.findByCode(anyString())).thenReturn(Optional.of(inventory));

        ResponseEntity<Inventory> responseEntity = controller.getInventory("somecode");
        verify(service,times(1)).findByCode(anyString());
        assertEquals(responseEntity.getBody(),inventory);
        assertEquals(responseEntity.getStatusCodeValue(),200);

    }

    @Test
    public void errorStatusIsReturnedWhenInventoryIsNotFound(){

        InventoryController controller = new InventoryController();
        InventoryService service = mock(InventoryService.class);
        controller.setInventoryService(service);
        when(service.findByCode(anyString())).thenReturn(Optional.empty());

        ResponseEntity<Inventory> responseEntity = controller.getInventory("somecode");
        verify(service,times(1)).findByCode(anyString());
        assertEquals(responseEntity.getBody(),null);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.NOT_FOUND);

    }
}
