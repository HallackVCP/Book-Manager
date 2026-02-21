package com.example.bmcommand.service;

import com.example.bmcommand.dto.request.CreateReview;
import com.example.bmcommand.dto.request.UpdateReview;
import com.example.bmcommand.dto.response.ReviewResponse;

public interface ReviewService {
    public ReviewResponse postReview(CreateReview createReviewRequest);
    public ReviewResponse updateReview(UpdateReview updateReviewRequest);
}
