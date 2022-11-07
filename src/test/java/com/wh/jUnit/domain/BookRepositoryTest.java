package com.wh.jUnit.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    public void defaultSaveBook(){
        String title = "스프링 부트";
        String author = "아무게";
        Book book = Book.builder()
                .title(title)
                .author(author)
                .build();

        bookRepository.save(book);
    }

    @Test
    public void createBook(){

        String title = "스프링 부트";
        String author = "아무게";
        Book book = Book.builder()
                .title(title)
                .author(author)
                .build();

        Book bookPS = bookRepository.save(book);

        assertEquals(title, bookPS.getTitle());
        assertEquals(author, bookPS.getAuthor());

    }

    @Test
    public void getBookList(){

        String title = "스프링 부트";
        String author = "아무게";

        List<Book> bookPSList = bookRepository.findAll();

        assertEquals(title, bookPSList.get(0).getTitle());
        assertEquals(author, bookPSList.get(0).getAuthor());
    }

    @Test
    public void getOneBook(){
        String title = "스프링 부트";
        String author = "아무게";


        Book bookPS = bookRepository.findById(1L).get();

        assertEquals(title, bookPS.getTitle());
        assertEquals(author, bookPS.getAuthor());
    }
}
