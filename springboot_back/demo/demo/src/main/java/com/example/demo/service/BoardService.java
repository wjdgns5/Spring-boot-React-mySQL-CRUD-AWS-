package com.example.demo.service;

import com.example.demo.dto.BoardRequestDTO;
import com.example.demo.dto.BoardResponseDTO;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardResponseDTO createBoard(BoardRequestDTO request, String username) {
        Board board = Board.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .writer(username)
                .build();

        Board savedBoard = boardRepository.save(board);
        return toDTO(savedBoard);
    }

    public List<BoardResponseDTO> getBoards() {
        return boardRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public BoardResponseDTO getBoard(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        return toDTO(board);
    }

    public BoardResponseDTO updateBoard(Long id, BoardRequestDTO request, String username) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));

        if (!board.getWriter().equals(username)) {
            throw new RuntimeException("본인 글만 수정할 수 있습니다.");
        }

        board.setTitle(request.getTitle());
        board.setContent(request.getContent());

        Board updatedBoard = boardRepository.save(board);
        return toDTO(updatedBoard);
    }

    public void deleteBoard(Long id, String username) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));

        if (!board.getWriter().equals(username)) {
            throw new RuntimeException("본인 글만 삭제할 수 있습니다.");
        }

        boardRepository.delete(board);
    }

    private BoardResponseDTO toDTO(Board board) {
        return BoardResponseDTO.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .createdAt(board.getCreatedAt())
                .updatedAt(board.getUpdatedAt())
                .build();
    }

    // 검색
    public List<BoardResponseDTO> searchBoards(String keyword) {
        return boardRepository
                .findByTitleContainingOrContentContainingOrWriterContaining(keyword, keyword, keyword)
                .stream()
                .map(this::toDTO)
                .toList();
    }
}