package com.project.CubeScramblerApi.CubeScramblerApi.controller;

import com.project.CubeScramblerApi.CubeScramblerApi.exception.CubeIsNotValidException;
import com.project.CubeScramblerApi.CubeScramblerApi.service.ScrambleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scramble")
public class ScrambleController {

    private final ScrambleService scrambleService;

    @Autowired
    public ScrambleController(ScrambleService scrambleService) {
        this.scrambleService = scrambleService;
    }

    @GetMapping
    public ResponseEntity<String> getScramble(@RequestParam("cube") String cube) {
        try {
            return ResponseEntity.ok(scrambleService.getScramble(cube));
        } catch (CubeIsNotValidException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
