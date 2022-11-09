package com.ll.ebook.app.product.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductDto {
    private Long id;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private Long authorId;
    private String authorName;
    private String subject;
}
