package com.tw.biblioteca.controller;

import com.tw.biblioteca.model.Item;
import com.tw.biblioteca.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(value = "/allItems", method = RequestMethod.GET)
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @RequestMapping(value = "/allItems/{itemType}", method = RequestMethod.GET)
    public List<Item> getItemsOfType(@PathVariable String itemType) {
        return itemService.getItemsOfType(itemType);
    }

    /*@ResponseBody
    @RequestMapping(value = "/bulkBook/insert", method = RequestMethod.POST)
    public void insertBulkBooks(@RequestBody String rawBooksData) throws Exception {
        itemService.insertBulkBooks(rawBooksData);
    }
*/
}
