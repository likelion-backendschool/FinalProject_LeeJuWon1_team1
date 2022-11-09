package com.ll.ebook.app.myBook.controller;

import com.ll.ebook.app.base.dto.RsData;
import com.ll.ebook.app.base.rq.Rq;
import com.ll.ebook.app.myBook.dto.MyBookDto;
import com.ll.ebook.app.myBook.dto.MyBookResponse;
import com.ll.ebook.app.myBook.dto.MyBooksResponse;
import com.ll.ebook.app.myBook.service.MyBookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.ALL_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/myBooks", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name = "ApiV1MyBooksController", description = "로그인 된 회윈이 구매한 책 정보")
public class ApiV1MyBooksController {

    private final MyBookService myBookService;
    private final Rq rq;

    @GetMapping(value = "", consumes = ALL_VALUE)
    @Operation(summary =  "로그인된 회원이 보유한 도서 목록", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<RsData<MyBooksResponse>> myBooks() {

    }

    @GetMapping(value = "{myBookId}", consumes = ALL_VALUE)
    @Operation(summary =  "로그인된 회원이 보유한 도서 목록", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<RsData<MyBookResponse>> myBooks(PathVariable myBookId) {

    }
}
