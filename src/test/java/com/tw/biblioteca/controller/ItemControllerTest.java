package com.tw.biblioteca.controller;

import com.tw.biblioteca.service.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {
    @Mock
    private ItemService itemService;


    @Test
    public void shouldCallGetAllBooksInBookService() {
        ItemController itemController = new ItemController(itemService);
        itemController.getAllItems();

        verify(itemService).getAllItems();
    }

    @Test
    public void shouldGetAllBooksInItemsService() {
        ItemController itemController = new ItemController(itemService);
        itemController.getItemsOfType("book");

        verify(itemService).getItemsOfType("book");
    }

    @Test
    public void shouldGetAllMOvieInItemsService() {
        ItemController itemController = new ItemController(itemService);
        itemController.getItemsOfType("movie");

        verify(itemService).getItemsOfType("movie");
    }

    /*@Test
    public void shouldCallInsetBookInService() throws Exception {
        ItemController itemController = new ItemController(itemService);
        String rawData = "195153448,Classical Mythology,Mark P. O. Morford,2002,Oxford University Press\n" +
                "2005018,Clara Callan,Richard Bruce Wright,2001,HarperFlamingo Canada";
        itemController.insertBulkBooks(rawData);

        verify(itemService).insertBulkBooks(rawData);
    }*/


}
