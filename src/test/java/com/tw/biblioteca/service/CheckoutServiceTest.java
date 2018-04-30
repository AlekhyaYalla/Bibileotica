package com.tw.biblioteca.service;

import com.tw.biblioteca.dal.CheckoutRepository;
import com.tw.biblioteca.dal.ItemRepository;
import com.tw.biblioteca.exception.ItemNotAvailableException;
import com.tw.biblioteca.exception.ItemNotFoundException;
import com.tw.biblioteca.model.Checkout;
import com.tw.biblioteca.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutServiceTest {

    @Mock
    private CheckoutRepository checkoutRepository;
    @Mock
    private ItemRepository itemRepository;
    @Mock
    private ItemService itemService;
    @Captor
    private ArgumentCaptor<Checkout> checkOutArgumentCaptor;


    @Test
    public void shouldCheckOutItem() throws ItemNotFoundException, ItemNotAvailableException {
        Item item = new Item("bb484940-3e2c-11e8-b566-0800200c9a66", "Harry Potter - The Philosphers stone",
                "2001", 3, "book", "978-3-16-148410-0,J. K. Rowling");
        when(itemRepository.getItem(item.getId())).thenReturn(item);

        Checkout checkout = new Checkout(item);
        CheckoutService checkoutService = new CheckoutService(checkoutRepository, itemRepository);
        checkoutService.insertCheckoutRecord(item.getId());

        verify(checkoutRepository).insertCheckoutRecord(checkOutArgumentCaptor.capture());
        assertThat(checkout.getItem_id()).isEqualTo("bb484940-3e2c-11e8-b566-0800200c9a66");
    }


    @Test(expected = ItemNotFoundException.class)
    public void shouldThrowExceptionIfBookIdIsInvalid() throws ItemNotFoundException, ItemNotAvailableException {
        CheckoutService checkoutService = new CheckoutService(checkoutRepository, itemRepository);
        checkoutService.insertCheckoutRecord("1234");
    }

    @Test(expected = ItemNotAvailableException.class)
    public void shouldThrowExceptionWhenBookIsNotAvailable() throws ItemNotFoundException, ItemNotAvailableException {
        CheckoutService checkoutService = new CheckoutService(checkoutRepository, itemRepository);
        Item item = new Item("1234", "title", "21", 3, "book", "test data");
        when(itemRepository.getItem(any())).thenReturn(item);
        when(checkoutRepository.getItemRecordsCount(item.getId())).thenReturn(3);
        checkoutService.insertCheckoutRecord("1234");
    }

  /*  @Test
    public void shouldReturnCheckoutBook() throws Exception {
        CheckoutService checkoutService = new CheckoutService(checkoutRepository, itemRepository);
        String checkout = "7c8f1879-61ed-4aa5-a903-d27b1faa994b";
        checkoutService.returnCheckoutBook(checkout,"20b5dcc0-3e2d-11e8-b566-0800200c9a66");
        verify(checkoutRepository).updateDateOfReturnInCheckout(checkout);
    }


    @Test
    public void shouldReturnFalseForIsReturnAvailableForCheckout(){
        CheckoutService checkoutService = new CheckoutService(checkoutRepository, itemRepository);
        Checkout checkout = new Checkout("7c8f1879-61ed-4aa5-a903-d27b1faa994b","20b5dcc0-3e2d-11e8-b566-0800200c9a66",
                new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()));
        assertFalse(checkoutService.isBookValidAndReturnAvailableForCheckout(checkout, checkout.getBook_id()));

    }

    @Test
    public void shouldReturnTrueForDateOfReturnNull(){
        CheckoutService checkoutService = new CheckoutService(checkoutRepository, itemRepository);
        Checkout checkout = new Checkout("b4f8f773-8aaa-43d6-bcb3-16f0ddd2d8f3","20b5dcc0-3e2d-11e8-b566-0800200c9a66",
                new Timestamp(System.currentTimeMillis()),null);
        assertTrue(checkoutService.isBookValidAndReturnAvailableForCheckout(checkout, checkout.getBook_id()));

    }

    @Test
    public void shouldReturnFalseForInvalidBook(){
        CheckoutService checkoutService = new CheckoutService(checkoutRepository, itemRepository);
        Checkout checkout = new Checkout("7c8f1879-61ed-4aa5-a903-d27b1faa994b","20b5dcc0-3e2d-11e8-b566-0800200c9a66",
                new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()));
        assertFalse(checkoutService.isBookValidAndReturnAvailableForCheckout(checkout, "12345"));

    }

    @Test
    public void shouldReturnTrueForValidBookAndDateOfReturnNull(){
        CheckoutService checkoutService = new CheckoutService(checkoutRepository, itemRepository);
        Checkout checkout = new Checkout("7c8f1879-61ed-4aa5-a903-d27b1faa994b","20b5dcc0-3e2d-11e8-b566-0800200c9a66",
                new Timestamp(System.currentTimeMillis()),null);
        assertTrue(checkoutService.isBookValidAndReturnAvailableForCheckout(checkout, checkout.getBook_id()));

    }

    @Test(expected = ReturnFailedException.class)
    public void shouldThrowErrorForIncorrectCheckoutBookId() throws Exception {
        CheckoutService checkoutService = new CheckoutService(checkoutRepository, itemRepository);
        String checkout = "7c8f1879-61ed-4aa5-a903-d27b1faa994b";
        checkoutService.returnCheckoutBook(checkout,"123");
    }

    @Test(expected = ReturnFailedException.class)
    public void shouldThrowErrorForIncorrectCheckoutId() throws Exception {
        CheckoutService checkoutService = new CheckoutService(checkoutRepository, itemRepository);
        String checkout = "123";
        checkoutService.returnCheckoutBook(checkout,"20b5dcc0-3e2d-11e8-b566-0800200c9a66");
    }

    @Test(expected = ReturnFailedException.class)
    public void shouldThrowErrorForAlreadyReturnedBook() throws Exception {
        CheckoutService checkoutService = new CheckoutService(checkoutRepository, itemRepository);
        String checkout = "7c8f1879-61ed-4aa5-a903-d27b1faa994b";
        checkoutService.returnCheckoutBook(checkout,"20b5dcc0-3e2d-11e8-b566-0800200c9a66");
    }
*/

}