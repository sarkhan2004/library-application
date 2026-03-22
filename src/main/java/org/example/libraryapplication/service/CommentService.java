package org.example.libraryapplication.service;

import lombok.RequiredArgsConstructor;
import org.example.libraryapplication.dto.comment.CommentRequestDto;
import org.example.libraryapplication.dto.comment.CommentResponseDto;
import org.example.libraryapplication.entity.Book;
import org.example.libraryapplication.entity.Comment;
import org.example.libraryapplication.entity.User;
import org.example.libraryapplication.exceptions.BookNotFoundException;
import org.example.libraryapplication.exceptions.CommentNotFoundException;
import org.example.libraryapplication.exceptions.UserNotFoundException;
import org.example.libraryapplication.mapper.CommentMapper;
import org.example.libraryapplication.repository.BookRepository;
import org.example.libraryapplication.repository.CommentRepository;
import org.example.libraryapplication.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public CommentResponseDto createComment(CommentRequestDto request) {
        Comment comment = commentMapper.toEntity(request);
        
        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new BookNotFoundException("Book with id " + request.getBookId() + " not found"));
        
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User with id " + request.getUserId() + " not found"));
        
        comment.setBook(book);
        comment.setUser(user);
        comment.setCreatedDate(LocalDateTime.now());
        
        Comment savedComment = commentRepository.save(comment);
        return commentMapper.toDto(savedComment);
    }

    public CommentResponseDto getCommentById(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new CommentNotFoundException("Comment with id " + id + " not found"));
        return commentMapper.toDto(comment);
    }

    public List<CommentResponseDto> getAllComments() {
        return commentRepository.findAllWithUserAndBook().stream()
                .map(commentMapper::toDto)
                .toList();
    }

    public List<CommentResponseDto> getCommentsByBookId(Long bookId) {
        return commentRepository.findByBookIdWithUser(bookId).stream()
                .map(commentMapper::toDto)
                .toList();
    }

    public List<CommentResponseDto> getCommentsByUserId(Long userId) {
        return commentRepository.findByUserIdWithBook(userId).stream()
                .map(commentMapper::toDto)
                .toList();
    }

    public CommentResponseDto updateComment(Long id, CommentRequestDto request) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new CommentNotFoundException("Comment with id " + id + " not found"));

        comment.setText(request.getText());
        comment.setRating(request.getRating());

        Comment updatedComment = commentRepository.save(comment);
        return commentMapper.toDto(updatedComment);
    }

    public void deleteComment(Long id) {
        if (!commentRepository.existsById(id)) {
            throw new CommentNotFoundException("Comment with id " + id + " not found");
        }
        commentRepository.deleteById(id);
    }
}
