package com.ll.ebook.app.myBook.dto;

import com.ll.ebook.app.product.dto.ProductDetailDto;
import lombok.Data;
import net.bytebuddy.asm.Advice;

import java.time.LocalDateTime;

@Data
public class MyBookDetailDto {
    private Long id;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private Long ownerId;
    private ProductDetailDto product;
}
