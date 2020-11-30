package com.sisprog.keyboard.service;

import com.sisprog.keyboard.dto.StatisticDto;

import java.util.List;

public interface StatisticService {
    StatisticDto getById(Long id);

    List<StatisticDto> getAll();

    StatisticDto save(StatisticDto zone);

    void update(StatisticDto zone);

    void delete(Long id);
}
