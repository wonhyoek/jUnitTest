package com.wh.jUnit.service;
import com.wh.jUnit.domain.Book;
import com.wh.jUnit.domain.BookRepository;
import com.wh.jUnit.util.MailSender;
import com.wh.jUnit.web.dto.BookRespDto;
import com.wh.jUnit.web.dto.BookSaveReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final MailSender mailSender;

    @Transactional(rollbackFor = RuntimeException.class)
    public BookRespDto createBook(BookSaveReqDto dto){
        Book bookPS = bookRepository.save(dto.toEntity());
        if(bookPS != null){
            if(!mailSender.send()){
                throw new RuntimeException("메일이 전송되지 않았습니다.");
            }
        }
        return new BookRespDto().toDto(bookPS);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public List<BookRespDto> getBookList (){
        return bookRepository
                .findAll()
                .stream()
                .map(new BookRespDto()::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public BookRespDto getOneBook(Long id){
        Optional<Book> bookOP = bookRepository.findById(id);
        if(bookOP.isPresent()){
            return new BookRespDto().toDto(bookOP.get());
        } else {
            throw new RuntimeException("해당되는 책을 찾을 수 없습니다.");
        }
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void updateBook(Long id, BookSaveReqDto dto){
        Optional<Book> bookOP = bookRepository.findById(id);
        if(bookOP.isPresent()){
            Book bookPS = bookOP.get();
            bookPS.update(dto);
        } else{
            throw new RuntimeException("해당되는 책을 찾을 수 없습니다.");
        }
    }
}
