package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Task;

import java.util.List;

public interface TaskService extends IService<Task> {

    List<Task> listUnfinished();
    List<Task> listExpired();
    List<Task> listUpcoming();
}