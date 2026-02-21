package com.example.bmcommand.dto.event;

import com.example.bmcommand.dto.response.BookResponse;

public record ReviewEvent(Long id, String content, int rating, Long bookId) {
}
