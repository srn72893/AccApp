package com.example.frfr_app.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Score {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;        //主キー

    @Column(name = "score")
    private double score;   //スコア

    @Column(name = "comment")
    private String comment; //コメント

    @Column(name = "created_at")
    private LocalDateTime createdAt;    //DB 書き込みタイムスタンプ

    public Score() {}
}
