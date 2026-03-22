package org.example.libraryapplication.repository;

import org.example.libraryapplication.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByBookId(Long bookId);
    List<Comment> findByUserId(Long userId);

    @Query("SELECT c FROM Comment c LEFT JOIN FETCH c.user LEFT JOIN FETCH c.book")
    List<Comment> findAllWithUserAndBook();

    @Query("SELECT c FROM Comment c LEFT JOIN FETCH c.user WHERE c.book.id = :bookId")
    List<Comment> findByBookIdWithUser(@Param("bookId") Long bookId);

    @Query("SELECT c FROM Comment c LEFT JOIN FETCH c.book WHERE c.user.id = :userId")
    List<Comment> findByUserIdWithBook(@Param("userId") Long userId);
}
