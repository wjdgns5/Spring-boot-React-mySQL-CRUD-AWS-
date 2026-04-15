package com.example.demo.controller;

import com.example.demo.dto.BoardRequestDTO;
import com.example.demo.dto.BoardResponseDTO;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public ResponseEntity<List<BoardResponseDTO>> getBoards() {
        return ResponseEntity.ok(boardService.getBoards());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardResponseDTO> getBoard(@PathVariable Long id) {
        return ResponseEntity.ok(boardService.getBoard(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<BoardResponseDTO>> searchBoards(@RequestParam String keyword) {
        return ResponseEntity.ok(boardService.searchBoards(keyword));
    }

    @PostMapping
    public ResponseEntity<BoardResponseDTO> createBoard(
            @RequestBody BoardRequestDTO request,
            Authentication authentication
    ) {
        String username = authentication.getName();
        return ResponseEntity.ok(boardService.createBoard(request, username));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoardResponseDTO> updateBoard(
            @PathVariable Long id,
            @RequestBody BoardRequestDTO request,
            Authentication authentication
    ) {
        String username = authentication.getName();
        return ResponseEntity.ok(boardService.updateBoard(id, request, username));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBoard(
            @PathVariable Long id,
            Authentication authentication
    ) {
        String username = authentication.getName();
        boardService.deleteBoard(id, username);
        return ResponseEntity.ok("삭제 완료");
    }

    // ------------- join -fetch 테스트용 -------------

    @GetMapping("/test/no-fetch")
    public ResponseEntity<List<BoardResponseDTO>> testNoFetch() {
        return ResponseEntity.ok(boardService.getBoardsWithoutFetchJoin());
    }

    @GetMapping("/test/fetch")
    public ResponseEntity<List<BoardResponseDTO>> testFetch() {
        return ResponseEntity.ok(boardService.getBoardsWithFetchJoin());
    }

}