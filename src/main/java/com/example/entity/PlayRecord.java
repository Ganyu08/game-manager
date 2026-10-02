package com.example.entity;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;

@Data
public class PlayRecord {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("game_id")
    private Integer gameId;

    private String playTime;

    private Integer duration;

    private String remark;
}