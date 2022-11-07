package com.wh.jUnit.service;

import com.wh.jUnit.domain.BookRepository;
import com.wh.jUnit.web.dto.BookSaveReqDto;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class BookServiceTest {

    private final BookRepository bookRepository;
    @Test
    public void createBook(BookSaveReqDto dto){
        bookRepository.save(dto.toEntity());
    }
}
