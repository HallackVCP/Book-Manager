package com.example.bmcommand.controller;

import com.example.bmcommand.dto.request.CreateReview;
import com.example.bmcommand.dto.request.UpdateReview;
import com.example.bmcommand.dto.response.ReviewResponse;
import com.example.bmcommand.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewResponse> postReview(@RequestBody CreateReview createReviewRequest) {
        return ResponseEntity.ok(reviewService.postReview(createReviewRequest));
    }

    @PutMapping
    public ResponseEntity<ReviewResponse> updateReview(@RequestBody UpdateReview updateReviewRequest){
        return ResponseEntity.ok(reviewService.updateReview(updateReviewRequest));
    }
}
