package com.example.controller;

import com.example.entity.Game;
import com.example.service.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<Game> list() {
        return gameService.list();
    }

    @GetMapping("/{id}")
    public Game getById(@PathVariable Integer id) {
        return gameService.getById(id);
    }

    @PostMapping
    public boolean add(@RequestBody Game game) {
        System.out.println(game);
        return gameService.save(game);
    }

    @PutMapping("/{id}")
    public boolean update(@PathVariable Integer id, @RequestBody Game game) {
        game.setId(id);
        return gameService.updateById(game);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return gameService.removeById(id);
    }
}