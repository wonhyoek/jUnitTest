package com.wh.jUnit.web.dto;

import com.wh.jUnit.domain.Book;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookSaveReqDto {
    private String title;
    private String author;

    public Book toEntity (){
        return Book.builder()
                .title(this.title)
                .author(this.author)
                .build();
    }
}
