package com.tw.biblioteca.dal;

import com.tw.biblioteca.BibliotecaApplication;
import com.tw.biblioteca.model.Book;
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
import static org.mockito.Mockito.when;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BibliotecaApplication.class)
@ActiveProfiles("test")
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    DSLContext dslContext;

    @Test
    public void shouldReturnListOfItems() {
        assertThat(itemRepository.getAllItems().size()).isEqualTo(7);
    }


    @Test
    public void shouldReturnListOfBooks() {
        assertThat(itemRepository.getItemsOfType("book").size()).isEqualTo(4);
    }


    @Test
    public void shouldReturnListOfMovies() {
        assertThat(itemRepository.getItemsOfType("movie").size()).isEqualTo(3);
    }


}
