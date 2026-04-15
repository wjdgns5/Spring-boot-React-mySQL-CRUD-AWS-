package com.example.demo.service;

import com.example.demo.dto.BoardRequestDTO;
import com.example.demo.dto.BoardResponseDTO;
import com.example.demo.entity.Board;
import com.example.demo.entity.User;
import com.example.demo.repository.BoardRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public BoardResponseDTO createBoard(BoardRequestDTO request, String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

        Board board = Board.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .user(user)
                .build();

        Board savedBoard = boardRepository.save(board);
        return toDTO(savedBoard);
    }

    // join-fetch 사용하는 성능시간 비교
    public List<BoardResponseDTO> getBoards() {
        long start = System.currentTimeMillis(); // 가져오기 성능 테스트 (시작)

        List<BoardResponseDTO> result = boardRepository.findAllWithUser()
                .stream()
                .map(this::toDTO)
                .toList();
        
        long end = System.currentTimeMillis(); // 가져오기 성능 테스트 (종료)
        System.out.println("fetch join 있음 (게시물 목록 조회 시간) = " + (end - start) + "ms");
        
        return result;
    }

    public BoardResponseDTO getBoard(Long id) {
        Board board = boardRepository.findByIdWithUser(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        return toDTO(board);
    }

    public List<BoardResponseDTO> searchBoards(String keyword) {
        return boardRepository.searchBoards(keyword)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public BoardResponseDTO updateBoard(Long id, BoardRequestDTO request, String username) {
        Board board = boardRepository.findByIdWithUser(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));

        if (!board.getUser().getUsername().equals(username)) {
            throw new RuntimeException("본인 글만 수정할 수 있습니다.");
        }

        board.setTitle(request.getTitle());
        board.setContent(request.getContent());

        Board updatedBoard = boardRepository.save(board);
        return toDTO(updatedBoard);
    }

    public void deleteBoard(Long id, String username) {
        Board board = boardRepository.findByIdWithUser(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));

        if (!board.getUser().getUsername().equals(username)) {
            throw new RuntimeException("본인 글만 삭제할 수 있습니다.");
        }

        boardRepository.delete(board);
    }

    private BoardResponseDTO toDTO(Board board) {
        return BoardResponseDTO.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getUser().getUsername())
                .createdAt(board.getCreatedAt())
                .updatedAt(board.getUpdatedAt())
                .build();
    }

    // ----------- Board Test ( Join fetch 테스트 )----
    public List<BoardResponseDTO> getBoardsWithoutFetchJoin() {
        long start = System.currentTimeMillis();

        List<BoardResponseDTO> result = boardRepository.findAllWithoutFetchJoin()
                .stream()
                .map(this::toDTO)
                .toList();

        long end = System.currentTimeMillis();
        System.out.println("fetch join NO - 목록 조회 시간: " + (end - start) + "ms");

        return result;
    }

    public List<BoardResponseDTO> getBoardsWithFetchJoin() {
        long start = System.currentTimeMillis();

        List<BoardResponseDTO> result = boardRepository.findAllWithFetchJoin()
                .stream()
                .map(this::toDTO)
                .toList();

        long end = System.currentTimeMillis();
        System.out.println("fetch join YES - 목록 조회 시간: " + (end - start) + "ms");

        return result;
    }
}