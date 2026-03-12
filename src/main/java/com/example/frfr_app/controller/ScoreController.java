package com.example.frfr_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.frfr_app.dto.CommentRequest;
import com.example.frfr_app.dto.CommentResponse;
import com.example.frfr_app.dto.ScoreRequest;
import com.example.frfr_app.dto.ScoreResponse;
import com.example.frfr_app.service.ScoreService;

@Controller
public class ScoreController {
    private final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }
    
    /**
     * フロントからスコアデータを受け取り、 Service に回す
     * @param request
     * @return
     */
    @PostMapping("/score")
    public ScoreResponse submitScore(@RequestBody ScoreRequest request) {
        //TODO: フロントから受け取ったスコア関連データをServiceへ回す（DB参照）
        // TOP5 ならコメント入力画面へ 
        
        return response;
    }

    /**
     * コメント入力後、フロントからデータを受け取り Service に回す
     * @param entity
     * @return
     */
    @PostMapping("/comment")
    public CommentResponse postMethodName(@RequestBody CommentRequest request) {
        //TODO : TOP5 にランクインした人のコメントを処理
        
        return response;
    }
    
    /**
     * ランキング表示リクエストが来たら現在のランキングをフロントへ返す
     * @param param
     * @return
     */
    @GetMapping("/ranking")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
}
