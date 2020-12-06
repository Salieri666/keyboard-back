package com.sisprog.keyboard.service;

import com.sisprog.keyboard.dto.ExerciseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ExerciseService {

    ExerciseDto getById(Long id);

    List<ExerciseDto> getAll();

    ExerciseDto save(ExerciseDto zone);

    void update(ExerciseDto zone);

    void delete(Long id);

    Page<ExerciseDto> getAllByPage(Pageable pageable);
}
