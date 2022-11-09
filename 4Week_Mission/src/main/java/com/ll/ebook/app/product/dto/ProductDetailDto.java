package com.ll.ebook.app.product.dto;

import com.ll.ebook.app.myBook.dto.BookChapterDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductDetailDto {
    private Long id;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private Long authorId;
    private String authorName;
    private String subject;
    private BookChapterDto bookChapters;
}
