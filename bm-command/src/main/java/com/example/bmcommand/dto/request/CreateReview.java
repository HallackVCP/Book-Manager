package com.example.bmcommand.dto.request;

public record CreateReview(Long bookId, String reviewerName, String content, int rating) {
}
