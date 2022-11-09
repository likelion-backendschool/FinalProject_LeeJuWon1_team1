package com.ll.ebook.app.myBook.dto;

import com.ll.ebook.app.product.dto.ProductDto;
import lombok.Data;
import net.bytebuddy.asm.Advice;

import java.time.LocalDateTime;

@Data
public class MyBookDto {
    private Long id;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private Long ownerId;
    private ProductDto productDto;
}
