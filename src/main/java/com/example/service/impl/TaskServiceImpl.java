package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Task;
import com.example.mapper.TaskMapper;
import com.example.service.TaskService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;


@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task>
        implements TaskService {
    @Override
    public List<Task> listUnfinished() {
        return lambdaQuery()
                .eq(Task::getStatus, 0)
                .orderByAsc(Task::getDeadline)
                .list();
    }

    @Override
    public List<Task> listExpired() {

        List<Task> tasks = list();

        LocalDateTime now = LocalDateTime.now();

        List<Task> expiredTasks = new ArrayList<>();

        for (Task task : tasks) {

            if (task.getDeadline().isBefore(now)) {
                expiredTasks.add(task);
            }
        }

        return expiredTasks;
    }

    @Override
    public List<Task> listUpcoming() {

        List<Task> tasks = listUnfinished();

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tomorrow = now.plusHours(24);

        List<Task> upcomingTasks = new ArrayList<>();

        for (Task task : tasks) {

            if (task.getDeadline().isAfter(now)
                    && task.getDeadline().isBefore(tomorrow)) {

                upcomingTasks.add(task);
            }
        }

        return upcomingTasks;
    }

    }
