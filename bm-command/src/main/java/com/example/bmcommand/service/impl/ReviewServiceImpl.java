package com.example.bmcommand.service.impl;

import com.example.bmcommand.domain.Review;
import com.example.bmcommand.dto.request.CreateReview;
import com.example.bmcommand.dto.request.UpdateReview;
import com.example.bmcommand.dto.response.ReviewResponse;
import com.example.bmcommand.map.ReviewMapper;
import com.example.bmcommand.repository.ReviewRepository;
import com.example.bmcommand.service.BrokerService;
import com.example.bmcommand.service.ReviewService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    private final ReviewMapper reviewMapper;

    @Autowired
    private BrokerService brokerService;

    @Override
    public ReviewResponse postReview(CreateReview createReviewRequest) {
        Review review = reviewMapper.toEntity(createReviewRequest);
        Review savedReview = reviewRepository.save(review);
        brokerService.send("review", reviewMapper.toEvent(savedReview));
        return reviewMapper.toResponse(savedReview);
    }

    @Override
    public ReviewResponse updateReview(UpdateReview updateReviewRequest) {
        if (!reviewRepository.existsById(updateReviewRequest.id())) {
            throw new EntityNotFoundException("Review não encontrado com o ID: " + updateReviewRequest.id());
        }
        Review review = reviewMapper.toEntity(updateReviewRequest);
        Review updatedReview = reviewRepository.save(review);
        brokerService.send("review", reviewMapper.toEvent(updatedReview));
        return reviewMapper.toResponse(updatedReview);
    }
}
