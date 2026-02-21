package com.example.bmcommand.dto.response;

public record ReviewResponse (Long id, String content, int rating, BookResponse bookResponse){
}
