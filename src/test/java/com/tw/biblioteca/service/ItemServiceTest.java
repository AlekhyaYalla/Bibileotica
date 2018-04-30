package com.tw.biblioteca.service;

import com.tw.biblioteca.dal.ItemRepository;
import com.tw.biblioteca.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @Test
    public void shouldCallGetAllItemsInItemRepo(){
        ItemService itemService = new ItemService(itemRepository);

        itemService.getAllItems();

        verify(itemRepository).getAllItems();
    }

    @Test
    public void shouldCallGetBooksTypeInRepo(){
        ItemService itemService = new ItemService(itemRepository);

        itemService.getItemsOfType("book");

        verify(itemRepository).getItemsOfType("book");
    }
    @Test
    public void shouldCallGetMoviesTypeInRepo(){
        ItemService itemService = new ItemService(itemRepository);

        itemService.getItemsOfType("movie");

        verify(itemRepository).getItemsOfType("movie");
    }
   /* @Test
    public void shouldCallInsertBookInService() throws Exception {
        ItemService itemService = new ItemService(itemRepository);
        String rawData = "195153448,Classical Mythology,Mark P. O. Morford,2002,Oxford University Press\n" +
                "2005018,Clara Callan,Richard Bruce Wright,2001,HarperFlamingo Canada";
        Book book = new Book("9333f964-0dd3-49d6-8856-2ead194e9eb2",
                "Classical Mythology", "Mark P. O. Morford",
                "2002", "195153448", 1);
        itemService.insertBulkBooks(rawData);

        verify(itemRepository).insertBook(book);


    }*/


}
