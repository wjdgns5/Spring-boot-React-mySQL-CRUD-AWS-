package com.example.demo.repository;

import com.example.demo.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query("select b from Board b join fetch b.user")
    List<Board> findAllWithUser();

    @Query("select b from Board b join fetch b.user where b.id = :id")
    Optional<Board> findByIdWithUser(@Param("id") Long id);

    @Query("""
        select b from Board b
        join fetch b.user u
        where b.title like %:keyword%
           or b.content like %:keyword%
           or u.username like %:keyword%
    """)
    List<Board> searchBoards(@Param("keyword") String keyword);



    // -------- join - fetch 여부 테스트 -----------
    @Query("select b from Board b")
    List<Board> findAllWithoutFetchJoin();

    @Query("select b from Board b join fetch b.user")
    List<Board> findAllWithFetchJoin();

}