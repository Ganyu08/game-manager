package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Game;
import com.example.mapper.GameMapper;
import com.example.service.GameService;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl extends ServiceImpl<GameMapper, Game>
        implements GameService {
}