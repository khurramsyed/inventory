package com.leanmentors.shopping.inventory.services;

import com.leanmentors.shopping.inventory.entities.Item;
import com.leanmentors.shopping.inventory.repositories.ItemRepository;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class ItemRepositoryServiceTest {

    ItemRepository itemRepository =mock(ItemRepository.class);

    @Test
    public void findByCodeShouldNotReturnAnythingIfRepositoryGivesNothing(){
        ItemService itemService = new ItemService(itemRepository);
        when(itemRepository.findByCode(anyString())).thenReturn(Optional.empty());

        Optional<Item> item = itemService.findByCode("Hello");

        assertFalse(item.isPresent());
        verify(itemRepository, times(1)).findByCode("Hello");
    }



    @Test
    public void findByCodeShouldNotReturnWhatRepositoryGives(){
        ItemService itemService = new ItemService(itemRepository);
        Item item = new Item();
        when(itemRepository.findByCode(anyString())).thenReturn(Optional.of(item));

        Optional<Item> returnedItem = itemService.findByCode("Hello");

        assertTrue(returnedItem.isPresent());
        assertEquals(item, returnedItem.get());
        verify(itemRepository, times(1)).findByCode("Hello");
    }
}
