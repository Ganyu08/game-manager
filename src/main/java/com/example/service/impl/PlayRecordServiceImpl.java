package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.PlayRecord;
import com.example.mapper.PlayRecordMapper;
import com.example.service.PlayRecordService;
import org.springframework.stereotype.Service;

@Service
public class PlayRecordServiceImpl extends ServiceImpl<PlayRecordMapper, PlayRecord>
        implements PlayRecordService {
}