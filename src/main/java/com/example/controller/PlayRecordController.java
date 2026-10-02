package com.example.controller;

import com.example.entity.PlayRecord;
import com.example.service.PlayRecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@RestController
@RequestMapping("/play-records")
public class PlayRecordController {

    private final PlayRecordService playRecordService;

    public PlayRecordController(PlayRecordService playRecordService) {
        this.playRecordService = playRecordService;
    }

    @GetMapping
    public List<PlayRecord> list() {
        return playRecordService.list();
    }

    @PostMapping
    public boolean add(@RequestBody PlayRecord playRecord) {
        return playRecordService.save(playRecord);
    }

    @PutMapping("/{id}")
    public boolean update(@PathVariable Integer id, @RequestBody PlayRecord playRecord) {
        playRecord.setId(id);
        return playRecordService.updateById(playRecord);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return playRecordService.removeById(id);
    }
}