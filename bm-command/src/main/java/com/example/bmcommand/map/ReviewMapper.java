package com.example.bmcommand.map;

import com.example.bmcommand.domain.Review;
import com.example.bmcommand.dto.event.ReviewEvent;
import com.example.bmcommand.dto.request.CreateReview;
import com.example.bmcommand.dto.request.UpdateReview;
import com.example.bmcommand.dto.response.ReviewResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {BookMapper.class})
public interface ReviewMapper {

    // CreateReview -> Review
    // Mapeia 'content' para 'comment' e 'bookId' para a entidade 'book'
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "content", target = "comment")
    @Mapping(source = "bookId", target = "book.id")
    Review toEntity(CreateReview dto);

    // UpdateReview -> Review
    @Mapping(source = "content", target = "comment")
    @Mapping(target = "reviewerName", ignore = true)
    @Mapping(target = "book", ignore = true)
    Review toEntity(UpdateReview dto);

    // Review (Entity) -> ReviewResponse (DTO)
    // Mapeia 'comment' de volta para 'content' e usa o BookMapper para o 'bookResponse'
    @Mapping(source = "comment", target = "content")
    @Mapping(source = "book", target = "bookResponse")
    ReviewResponse toResponse(Review entity);

    ReviewEvent toEvent(Review entity);
}