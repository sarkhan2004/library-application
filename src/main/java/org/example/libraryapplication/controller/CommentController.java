package org.example.libraryapplication.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.libraryapplication.dto.comment.CommentRequestDto;
import org.example.libraryapplication.dto.comment.CommentResponseDto;
import org.example.libraryapplication.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public CommentResponseDto createComment(@Valid @RequestBody CommentRequestDto request) {
        return commentService.createComment(request);
    }

    @GetMapping("/{id}")
    public CommentResponseDto getCommentById(@PathVariable Long id) {
        return commentService.getCommentById(id);
    }

    @GetMapping
    public List<CommentResponseDto> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/book/{bookId}")
    public List<CommentResponseDto> getCommentsByBookId(@PathVariable Long bookId) {
        return commentService.getCommentsByBookId(bookId);
    }

    @GetMapping("/user/{userId}")
    public List<CommentResponseDto> getCommentsByUserId(@PathVariable Long userId) {
        return commentService.getCommentsByUserId(userId);
    }

    @PutMapping("/{id}")
    public CommentResponseDto updateComment(@PathVariable Long id, @Valid @RequestBody CommentRequestDto request) {
        return commentService.updateComment(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }
}
