package com.wh.jUnit.web.dto;

import com.wh.jUnit.domain.Book;
import lombok.Getter;

@Getter
public class BookRespDto {
    private Long id;
    private String title;
    private String author;

    public BookRespDto toDto(Book bookPS){
        this.id = bookPS.getId();
        this.title = bookPS.getTitle();
        this.author = bookPS.getAuthor();
        return this;
    }
}
