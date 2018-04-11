package com.leanmentors.shopping.inventory.controller;

import com.leanmentors.shopping.inventory.entities.Item;
import com.leanmentors.shopping.inventory.services.ItemService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class ItemControllerTest {

    ItemController controller;
    ItemService service;

    @Before
    public void setup(){
        controller = new ItemController();
        service = mock(ItemService.class);
        controller.setItemService(service);
    }


    @Test
    public void controllerShouldGetsDataFromService(){

        Item item = new Item();
        item.setId(1L);
        when(service.fetchByCode(anyString())).thenReturn(Optional.of(item));

        ResponseEntity<Item> responseEntity = controller.fetchItemByCode("somecode");
        verify(service,times(1)).fetchByCode(anyString());
        assertEquals(responseEntity.getBody(),item);
        assertEquals(responseEntity.getStatusCodeValue(),200);

    }

    @Test
    public void errorStatusIsReturnedWhenItemIsNotFound(){

        when(service.fetchByCode(anyString())).thenReturn(Optional.empty());

        ResponseEntity<Item> responseEntity = controller.fetchItemByCode("somecode");
        verify(service,times(1)).fetchByCode(anyString());
        assertEquals(responseEntity.getBody(),null);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.NOT_FOUND);

    }

    @Test
    public void ensureThatFindAllUsesService(){
        List<Item> items = new ArrayList<>();
        when(service.fetchAll()).thenReturn(items);
        List<Item> fetchedItems  = controller.fetchAllItems();
        verify(service,times(1)).fetchAll();
        assertEquals(items,fetchedItems);

    }
}
