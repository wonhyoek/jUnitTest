package com.wh.jUnit.domain;

import com.wh.jUnit.web.dto.BookSaveReqDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String title;
    @Column(length = 20, nullable = false)
    private String author;

    public void update(BookSaveReqDto dto){
        this.author = dto.getAuthor();
        this.title = dto.getTitle();
    }
}
