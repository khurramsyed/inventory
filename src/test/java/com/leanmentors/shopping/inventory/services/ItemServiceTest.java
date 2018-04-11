package com.leanmentors.shopping.inventory.services;

import com.leanmentors.shopping.inventory.entities.Item;
import com.leanmentors.shopping.inventory.repositories.ItemRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class ItemServiceTest {

    ItemRepository itemRepository ;
    ItemService itemService ;

    @Before
    public void setup() {
        itemRepository = mock(ItemRepository.class);
        itemService = new ItemService(itemRepository);
    }

    @Test
    public void findByCodeShouldNotReturnAnythingIfRepositoryGivesNothing(){

        when(itemRepository.findByCode(anyString())).thenReturn(Optional.empty());
        Optional<Item> item = itemService.fetchByCode("Hello");
        assertFalse(item.isPresent());
        verify(itemRepository, times(1)).findByCode("Hello");
    }



    @Test
    public void findByCodeShouldNotReturnWhatRepositoryGives(){

        Item item = new Item();
        when(itemRepository.findByCode(anyString())).thenReturn(Optional.of(item));

        Optional<Item> returnedItem = itemService.fetchByCode("Hello");

        assertTrue(returnedItem.isPresent());
        assertEquals(item, returnedItem.get());
        verify(itemRepository, times(1)).findByCode("Hello");
    }

    @Test
    public void testFetchAll(){

        List<Item> items = new ArrayList<>();
        when(itemRepository.findAll()).thenReturn(items);
        List<Item> returnedItems = itemService.fetchAll();
        assertEquals(items, returnedItems);
        verify(itemRepository, times(1)).findAll();
    }
}

