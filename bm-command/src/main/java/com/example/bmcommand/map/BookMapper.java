package com.example.bmcommand.map;

import com.example.bmcommand.domain.Book;
import com.example.bmcommand.dto.event.BookEvent;
import com.example.bmcommand.dto.request.CreateBook;
import com.example.bmcommand.dto.request.UpdateBook;
import com.example.bmcommand.dto.response.BookResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    // Converte CreateBook (Request) para Entidade
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "review", ignore = true)
    Book toEntity(CreateBook dto);

    // Converte UpdateBook (Request) para Entidade
    @Mapping(target = "review", ignore = true)
    Book toEntity(UpdateBook dto);

    // Converte Entidade para BookResponse
    BookResponse toResponse(Book entity);

    BookEvent toEvent(Book entity);
}
