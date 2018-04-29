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
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    DSLContext dslContext;

    @Test
    public void shouldReturnListOfBooks() {
        assertThat(bookRepository.getAllBooks().size()).isEqualTo(4);
    }

    @Test
    public void shouldReturnTrueForPresentBookObject() {
        assertEquals(bookRepository.getBook("bb484940-3e2c-11e8-b566-0800200c9a66").getId(), "bb484940-3e2c-11e8-b566-0800200c9a66");
    }

    @Test
    public void shouldReturnBook() {
        Book book = new Book("3245dfe6-b382-400a-a255-5dc7ba98987b",
                "Socerers stone", "J K Rowling",
                "2000", "978-3-16-148410-0", 2);

        when(bookRepository.getBook(book.getId())).thenReturn(book);
        assertThat(bookRepository.getBook(book.getId())).isEqualTo(book);
    }

    @Test
    public void shouldInsertBook() {
        Book book = new Book("9333f964-0dd3-49d6-8856-2ead194e9eb2",
                "Classical Mythology", "Mark P. O. Morford",
                "2002", "195153448", 1);

        int previousSize = bookRepository.getAllBooks().size();
        bookRepository.insertBook(book);
       assertEquals(previousSize+1,bookRepository.getAllBooks().size());

    }

}
