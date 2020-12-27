package com.sisprog.keyboard.controller;

import com.sisprog.keyboard.dto.ExerciseDto;
import com.sisprog.keyboard.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @DeleteMapping(value = "/deleteExercise/{id}", produces = APPLICATION_JSON_VALUE)
    public void deleteExercise(@PathVariable("id") Long id) {
        exerciseService.delete(id);
    }

    @GetMapping(value = "/getExercise/{id}", produces = APPLICATION_JSON_VALUE)
    public ExerciseDto getExercise(@PathVariable("id") Long id) {
        return exerciseService.getById(id);
    }

    @GetMapping(value = "/getAllExercises", produces = APPLICATION_JSON_VALUE)
    public List<ExerciseDto> getAllExercises() {
        return exerciseService.getAll();
    }

    @GetMapping(value = "/getAllExercisesByPage", produces = APPLICATION_JSON_VALUE)
    public Page<ExerciseDto> getAllExercisesByPage(Pageable pageable) {
        return exerciseService.getAllByPage(pageable);
    }

    @PostMapping(value = "/updateExercise", produces = APPLICATION_JSON_VALUE)
    public void updateExercise(@RequestBody ExerciseDto exerciseDto) {
        exerciseService.update(exerciseDto);
    }

    @PutMapping(value = "/saveExercise", produces = APPLICATION_JSON_VALUE)
    public ExerciseDto saveExercise(@RequestBody ExerciseDto exerciseDto) {
        return exerciseService.save(exerciseDto);
    }

    @GetMapping(value = "/getRandomExercise", produces = APPLICATION_JSON_VALUE)
    public ExerciseDto getRandomExercise() {
        return exerciseService.getRandomExercise();
    }

    @GetMapping(value = "/getExecutedExercisesByUser/{userId}")
    public List<ExerciseDto> getExecutedExercisesByUser(@PathVariable("userId") Long userId) {
        return exerciseService.getExecutedExercisesByUser(userId);
    }
}
