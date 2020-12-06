package com.sisprog.keyboard.service;

import com.sisprog.keyboard.dto.DifficultyLevelDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DifficultyLevelService {
    DifficultyLevelDto getLevelById(Long id);

    List<DifficultyLevelDto> getAllLevels();

    DifficultyLevelDto save(DifficultyLevelDto zone);

    void update(DifficultyLevelDto zone);

    void delete(Long id);

    Page<DifficultyLevelDto> getAllByPage(Pageable pageable);
}
