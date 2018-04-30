package com.tw.biblioteca.service;

import com.tw.biblioteca.dal.ItemRepository;
import com.tw.biblioteca.dal.CheckoutRepository;
import com.tw.biblioteca.exception.ItemNotAvailableException;
import com.tw.biblioteca.exception.ItemNotFoundException;
import com.tw.biblioteca.exception.ReturnFailedException;
import com.tw.biblioteca.model.Checkout;
import com.tw.biblioteca.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckoutService {

    private CheckoutRepository checkoutRepository;
    private ItemRepository itemRepository;

    @Autowired
    public CheckoutService(CheckoutRepository checkoutRepository, ItemRepository itemRepository) {
        this.checkoutRepository = checkoutRepository;
        this.itemRepository = itemRepository;
    }

    public void insertCheckoutRecord(String id) throws ItemNotFoundException, ItemNotAvailableException {
        Item item = itemRepository.getItem(id);
        if (item == null)
            throw new ItemNotFoundException("Item not Found in the Library");
        if (!isItemInStock(item))
            throw new ItemNotAvailableException("Item not available for check out");
        Checkout checkout = new Checkout(item);
        checkoutRepository.insertCheckoutRecord(checkout);
    }

   private Boolean isItemInStock(Item item) {
        return item.getCount() - checkoutRepository.getItemRecordsCount(item.getId()) > 0;
    }


   public Boolean isBookValidAndReturnAvailableForCheckout(Checkout checkoutRecord, String itemId) {
        return checkoutRecord.getDate_of_return() == null && checkoutRecord.getItem_id().equals(itemId);
    }

    public List<Checkout> getAllCheckouts() {

        return checkoutRepository.getAllCheckouts();
    }

    public void returnCheckoutItem(String checkoutId, String itemId) throws ReturnFailedException {
        Checkout checkoutRecord = checkoutRepository.getCheckoutRecord(checkoutId);
        if( checkoutRecord == null || !isBookValidAndReturnAvailableForCheckout(checkoutRecord, itemId))
            throw new ReturnFailedException("Return of Book failed");
        checkoutRepository.updateDateOfReturnInCheckout(checkoutId);
    }
}
