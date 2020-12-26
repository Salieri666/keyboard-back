package com.sisprog.keyboard.service;

import com.sisprog.keyboard.dao.DifficultyLevelDao;
import com.sisprog.keyboard.dao.ExerciseDao;
import com.sisprog.keyboard.dao.ZoneDao;
import com.sisprog.keyboard.domain.DifficultyLevel;
import com.sisprog.keyboard.domain.Zone;
import com.sisprog.keyboard.dto.ExerciseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService{
    private final ExerciseDao exerciseDao;
    private final DifficultyLevelDao difficultyLevelDao;
    private final ZoneDao zoneDao;

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

    @Override
    public ExerciseDto getRandomExercise() {
        Random random = new Random();

        List<DifficultyLevel> difficultyLevels = difficultyLevelDao.findAll();
        DifficultyLevel level = difficultyLevels.get(random.nextInt(difficultyLevels.size()+1));

        Zone zone = zoneDao.getOne(level.getZoneId());

        String symbols = zone.getSymbols();
        int size = (int)( Math.random() * ((level.getMaxLength()+1) - level.getMinLength()) ) + level.getMinLength();

        String randomString = new Random().ints(size, 0, symbols.length())
                .mapToObj(symbols::charAt)
                .map(Object::toString)
                .collect(Collectors.joining()).trim().replaceAll("\\s+", " ");

        ExerciseDto exerciseDto = new ExerciseDto();
        exerciseDto.setLevelId(level.getId());
        exerciseDto.setWords(randomString);

        return exerciseDto;
    }
}
