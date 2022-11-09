package com.ll.ebook.app.myBook.dto;

import lombok.Data;

@Data
public class BookChapterDto {
    private Long id;
    private String subject;
    private String content;
    private String contentHtml;
}
