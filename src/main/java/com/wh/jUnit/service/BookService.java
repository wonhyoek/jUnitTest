package com.wh.jUnit.service;
import com.wh.jUnit.domain.Book;
import com.wh.jUnit.domain.BookRepository;
import com.wh.jUnit.web.dto.BookRespDto;
import com.wh.jUnit.web.dto.BookSaveReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    @Transactional
    public BookRespDto createBook(BookSaveReqDto dto){
        Book bookPS = bookRepository.save(dto.toEntity());
        return new BookRespDto().toDto(bookPS);
    }


}
