package com.sisprog.keyboard.service;

import com.sisprog.keyboard.dao.DifficultyLevelDao;
import com.sisprog.keyboard.dao.ExerciseDao;
import com.sisprog.keyboard.dao.ZoneDao;
import com.sisprog.keyboard.domain.DifficultyLevel;
import com.sisprog.keyboard.domain.Zone;
import com.sisprog.keyboard.dto.ExerciseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        checkExercise(exerciseDto);
        try {
            return ExerciseDto.of(exerciseDao.save(ExerciseDto.of(exerciseDto)));
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getCause().getCause().getMessage());
        }
    }

    @Override
    public void update(ExerciseDto exerciseDto) {
        checkExercise(exerciseDto);
        try {
            exerciseDao.save(ExerciseDto.of(exerciseDto));
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getCause().getCause().getMessage());
        }
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

    @Override
    public List<ExerciseDto> getExecutedExercisesByUser(Long userId) {
        return exerciseDao.getExecutedExercisesByUser(userId).stream().map(ExerciseDto::of).collect(Collectors.toList());
    }

    private void checkExercise(ExerciseDto exerciseDto) {
        DifficultyLevel difficultyLevel = difficultyLevelDao.getOne(exerciseDto.getLevelId());
        Zone zone = zoneDao.getOne(difficultyLevel.getZoneId());


        String zoneText = (zone.getSymbols()+" ").toLowerCase();
        String text = exerciseDto.getWords().toLowerCase();

        if (text.length() < difficultyLevel.getMinLength() || text.length() > difficultyLevel.getMaxLength())
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Size is not correct!");

        char[] textArr = text.toCharArray();

        Stream<CharSequence> textStream = IntStream.range(0, textArr.length).mapToObj(i -> String.valueOf(textArr[i]));

        if(!textStream.allMatch(zoneText::contains))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Zone is not correct!");
    }
}
