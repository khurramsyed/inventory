package com.leanmentors.shopping.inventory.controller;

import com.leanmentors.shopping.inventory.entities.Item;
import com.leanmentors.shopping.inventory.services.ItemService;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class ItemControllerTest {

    @Test
    public void controllerShouldGetsDataFromService(){

        ItemController controller = new ItemController();
        ItemService service = mock(ItemService.class);
        controller.setItemService(service);
        Item item = new Item();
        item.setId(1L);
        when(service.findByCode(anyString())).thenReturn(Optional.of(item));

        ResponseEntity<Item> responseEntity = controller.getItem("somecode");
        verify(service,times(1)).findByCode(anyString());
        assertEquals(responseEntity.getBody(),item);
        assertEquals(responseEntity.getStatusCodeValue(),200);

    }

    @Test
    public void errorStatusIsReturnedWhenItemIsNotFound(){

        ItemController controller = new ItemController();
        ItemService service = mock(ItemService.class);
        controller.setItemService(service);
        when(service.findByCode(anyString())).thenReturn(Optional.empty());

        ResponseEntity<Item> responseEntity = controller.getItem("somecode");
        verify(service,times(1)).findByCode(anyString());
        assertEquals(responseEntity.getBody(),null);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.NOT_FOUND);

    }
}
