package com.tw.biblioteca.service;

import com.tw.biblioteca.dal.ItemRepository;
import com.tw.biblioteca.model.Book;
import com.tw.biblioteca.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ItemService {
    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    public List<Item> getAllItems() {
        return itemRepository.getAllItems();
    }


    public List<Item> getItemsOfType(String itemType) {
        return itemRepository.getItemsOfType(itemType);
    }


    /*public void insertBulkBooks(String rawData) throws Exception {
        String[] arrayOfEachBook = rawData.split("\\r?\\n");
        for (String eachBook : arrayOfEachBook) {
            String[] detailsOfEachBook = eachBook.split("\\s*,\\s*");

            Book book = new Book(UUID.randomUUID().toString(), detailsOfEachBook[1],
                    detailsOfEachBook[2], detailsOfEachBook[3], detailsOfEachBook[0], Integer.parseInt(detailsOfEachBook[4]));
            validateBookData(book);
            itemRepository.insertBook(book);
        }

    }*/

    /*private void validateBookData(Book book) throws Exception {
        if(isIsbnAlreadyPresent(book.getIsbn()))
            throw new Exception("ISBN is already present");
       *//* if(validateField(book))
            throw new Exception("Pattern is not good");*//*
    }
*/
    /*private boolean isIsbnAlreadyPresent(String isbn) {
        if(itemRepository.getBooksForIsbn(isbn)!=null)
            return true;
        return false;
    }*/


    /*public void insertBook(String rawData) {
        String[] detailsOfEachBook = rawData.split("\\s*,\\s*");
        Book book = new Book(UUID.randomUUID().toString(), detailsOfEachBook[1],
                detailsOfEachBook[2], detailsOfEachBook[3], detailsOfEachBook[0], 1);
        itemRepository.insertBook(book);
    }*/
}
