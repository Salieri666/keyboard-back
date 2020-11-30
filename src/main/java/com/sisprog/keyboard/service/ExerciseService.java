package com.sisprog.keyboard.service;

import com.sisprog.keyboard.dto.ExerciseDto;

import java.util.List;

public interface ExerciseService {

    ExerciseDto getById(Long id);

    List<ExerciseDto> getAll();

    ExerciseDto save(ExerciseDto zone);

    void update(ExerciseDto zone);

    void delete(Long id);
}
