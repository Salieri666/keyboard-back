package com.sisprog.keyboard.service;

import com.sisprog.keyboard.dto.StatisticDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StatisticService {
    StatisticDto getById(Long id);

    List<StatisticDto> getAll();

    StatisticDto save(StatisticDto zone);

    void update(StatisticDto zone);

    void delete(Long id);

    Page<StatisticDto> getAllByPage(Pageable pageable);

    List<StatisticDto> getByUser(Long userId);
}
