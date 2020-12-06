package com.sisprog.keyboard.service;

import com.sisprog.keyboard.dao.ExerciseDao;
import com.sisprog.keyboard.dto.ExerciseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService{
    private final ExerciseDao exerciseDao;

    @Override
    public ExerciseDto getById(Long id) {
        return ExerciseDto.of(exerciseDao.getOne(id));
    }

    @Override
    public List<ExerciseDto> getAll() {
        return exerciseDao.findAll().stream().map(ExerciseDto::of).collect(Collectors.toList());
    }

    @Override
    public ExerciseDto save(ExerciseDto exerciseDto) {
        return ExerciseDto.of(exerciseDao.save(ExerciseDto.of(exerciseDto)));
    }

    @Override
    public void update(ExerciseDto exerciseDto) {
        exerciseDao.save(ExerciseDto.of(exerciseDto));
    }

    @Override
    public void delete(Long id) {
        exerciseDao.deleteById(id);
    }

    @Override
    public Page<ExerciseDto> getAllByPage(Pageable pageable) {
        return exerciseDao.findAll(pageable).map(ExerciseDto::of);
    }
}
