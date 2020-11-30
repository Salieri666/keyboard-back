package com.sisprog.keyboard.controller;

import com.sisprog.keyboard.dto.ExerciseDto;
import com.sisprog.keyboard.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping(value = "/updateExercise", produces = APPLICATION_JSON_VALUE)
    public void updateExercise(@RequestBody ExerciseDto exerciseDto) {
        exerciseService.update(exerciseDto);
    }

    @PutMapping(value = "/saveExercise", produces = APPLICATION_JSON_VALUE)
    public ExerciseDto saveExercise(@RequestBody ExerciseDto exerciseDto) {
        return exerciseService.save(exerciseDto);
    }
}
