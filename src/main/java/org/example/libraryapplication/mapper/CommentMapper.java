package org.example.libraryapplication.mapper;

import org.example.libraryapplication.dto.comment.CommentRequestDto;
import org.example.libraryapplication.dto.comment.CommentResponseDto;
import org.example.libraryapplication.entity.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {

    public CommentResponseDto toDto(Comment comment) {
        CommentResponseDto response = new CommentResponseDto();
        response.setId(comment.getId());
        response.setText(comment.getText());
        response.setRating(comment.getRating());
        response.setCreatedDate(comment.getCreatedDate());
        
        if (comment.getUser() != null) {
            response.setUserName(comment.getUser().getName() + " " + comment.getUser().getSurname());
        }
        
        if (comment.getBook() != null) {
            response.setBookName(comment.getBook().getName());
        }
        
        return response;
    }

    public Comment toEntity(CommentRequestDto request) {
        Comment comment = new Comment();
        comment.setText(request.getText());
        comment.setRating(request.getRating());

        return comment;
    }
}
