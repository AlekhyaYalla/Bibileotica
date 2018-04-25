package com.tw.biblioteca.dal;

import com.tw.biblioteca.BibliotecaApplication;
import org.jooq.DSLContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

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

}
