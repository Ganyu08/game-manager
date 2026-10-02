package com.example.entity;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import java.time.LocalDateTime;

@Data
public class Task {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("game_id")
    private Integer gameId;

    private String title;

    private LocalDateTime deadline;

    private String reward;

    private Integer status;
}