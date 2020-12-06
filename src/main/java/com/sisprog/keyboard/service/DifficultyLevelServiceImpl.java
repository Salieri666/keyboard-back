package com.sisprog.keyboard.service;

import com.sisprog.keyboard.dao.DifficultyLevelDao;
import com.sisprog.keyboard.dto.DifficultyLevelDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DifficultyLevelServiceImpl implements DifficultyLevelService {
    private final DifficultyLevelDao difficultyLevelDao;

    @Override
    public DifficultyLevelDto getLevelById(Long id) {
        return DifficultyLevelDto.of(difficultyLevelDao.getOne(id));
    }

    @Override
    public List<DifficultyLevelDto> getAllLevels() {
        return difficultyLevelDao.findAll().stream().map(DifficultyLevelDto::of).collect(Collectors.toList());
    }

    @Override
    public DifficultyLevelDto save(DifficultyLevelDto level) {
        return DifficultyLevelDto.of(difficultyLevelDao.save(DifficultyLevelDto.of(level)));
    }

    @Override
    public void update(DifficultyLevelDto level) {
        difficultyLevelDao.save(DifficultyLevelDto.of(level));
    }

    @Override
    public void delete(Long id) {
        difficultyLevelDao.deleteById(id);
    }

    @Override
    public Page<DifficultyLevelDto> getAllByPage(Pageable pageable) {
        return difficultyLevelDao.findAll(pageable).map(DifficultyLevelDto::of);
    }
}
