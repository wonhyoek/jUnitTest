package com.wh.jUnit.service;
import com.wh.jUnit.domain.Book;
import com.wh.jUnit.domain.BookRepository;
import com.wh.jUnit.web.dto.BookRespDto;
import com.wh.jUnit.web.dto.BookSaveReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    @Transactional
    public BookRespDto createBook(BookSaveReqDto dto){
        Book bookPS = bookRepository.save(dto.toEntity());
        return new BookRespDto().toDto(bookPS);
    }

    @Transactional
    public List<BookRespDto> getBookList (){
        return bookRepository
                .findAll()
                .stream()
                .map(new BookRespDto()::toDto)
                .collect(Collectors.toList());
    }
}
