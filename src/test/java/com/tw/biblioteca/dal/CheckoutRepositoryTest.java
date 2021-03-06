package com.tw.biblioteca.dal;

import com.tw.biblioteca.BibliotecaApplication;
import com.tw.biblioteca.exception.ReturnFailedException;
import com.tw.biblioteca.model.Checkout;
import org.jooq.DSLContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BibliotecaApplication.class)
@ActiveProfiles("test")
public class CheckoutRepositoryTest {

    @Autowired
    private CheckoutRepository checkoutRepository;

    @Autowired
    DSLContext dslContext;

    @Test
    public void shouldReturnInsertedCheckoutRecord() {
        assertEquals(checkoutRepository.getAllCheckouts().size(),1);
    }


    @Test
    public void shouldReturnCountOfBookRecords(){
        assertThat(checkoutRepository.getItemRecordsCount("20b5dcc0-3e2d-11e8-b566-0800200c9a66")).isEqualTo(4);
    }

    @Test
    public void shouldUpdateDateOfReturnColumn(){
         checkoutRepository.updateDateOfReturnInCheckout("a40f9a22-0d09-4a11-bf9d-64009bcb7c4c");
         Checkout checkout = checkoutRepository.getCheckoutRecord("a40f9a22-0d09-4a11-bf9d-64009bcb7c4c");
         assertThat(checkout.getDate_of_return()).isNotNull();

    }




}
