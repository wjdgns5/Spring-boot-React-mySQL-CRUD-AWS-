package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

// Lombok 어노테이션
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title; // 제목

    @Column(nullable = false, length = 3000)
    private String content; // 내용 

    @Column(nullable = false, length = 100)
    private String writer; // 작성자

    private LocalDateTime createdAt; // 생성일
    private LocalDateTime updatedAt; // 수정일

    @PrePersist
    // PrePersist: 데이터베이스에 영속화(저장, INSERT)되기 직전에 자동으로 로직을 수행
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    // PreUpdate: 데이터베이스에서 업데이트(UPDATE) 되기 직전에 자동으로 특정 메서드를 실행하는 어노테이션
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
