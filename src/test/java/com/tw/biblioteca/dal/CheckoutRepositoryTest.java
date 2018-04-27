package com.tw.biblioteca.dal;

import com.tw.biblioteca.BibliotecaApplication;
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
        assertEquals(checkoutRepository.getAllCheckouts().size(),7);
    }

    @Test
    public void shouldReturnCheckoutsCount(){
        assertEquals(checkoutRepository.getAllCheckouts().size(),7);
    }

    @Test
    public void shouldReturnCountOfBookRecords(){
        assertThat(checkoutRepository.getBookRecordsCount("20b5dcc0-3e2d-11e8-b566-0800200c9a66")).isEqualTo(4);
    }

    @Test
    public void shouldUpdateDateOfReturnInCheckoutWithCurrentDateAndTime(){

        String checkoutId = "7c8f1879-61ed-4aa5-a903-d27b1faa994b";
        checkoutRepository.updateDateOfReturnInCheckout(checkoutId);
        Checkout updatedCheckout = checkoutRepository.getCheckoutRecord(checkoutId);
        assertThat(updatedCheckout.getDate_of_return()).isNotNull();

    }

}
