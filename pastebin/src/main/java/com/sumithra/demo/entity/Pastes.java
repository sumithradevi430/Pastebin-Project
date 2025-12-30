package com.sumithra.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Pastes {
    @Id
    private String id;
    @Lob
    @Column(nullable = false)
    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime expiresAt;

    private Integer maxViews;

    private Integer viewCount;
}
