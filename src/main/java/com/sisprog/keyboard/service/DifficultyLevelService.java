package com.sisprog.keyboard.service;

import com.sisprog.keyboard.dto.DifficultyLevelDto;

import java.util.List;

public interface DifficultyLevelService {
    DifficultyLevelDto getLevelById(Long id);

    List<DifficultyLevelDto> getAllLevels();

    DifficultyLevelDto save(DifficultyLevelDto zone);

    void update(DifficultyLevelDto zone);

    void delete(Long id);
}
