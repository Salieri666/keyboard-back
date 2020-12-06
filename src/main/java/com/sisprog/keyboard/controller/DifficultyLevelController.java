package com.sisprog.keyboard.controller;

import com.sisprog.keyboard.dto.DifficultyLevelDto;
import com.sisprog.keyboard.service.DifficultyLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/level")
public class DifficultyLevelController {

    @Autowired
    private DifficultyLevelService difficultyLevelService;

    @DeleteMapping(value = "/deleteLevel/{id}", produces = APPLICATION_JSON_VALUE)
    public void deleteLevel(@PathVariable("id") Long id) {
        difficultyLevelService.delete(id);
    }

    @GetMapping(value = "/getLevel/{id}", produces = APPLICATION_JSON_VALUE)
    public DifficultyLevelDto getLevel(@PathVariable("id") Long id) {
        return difficultyLevelService.getLevelById(id);
    }

    @GetMapping(value = "/getAllLevels", produces = APPLICATION_JSON_VALUE)
    public List<DifficultyLevelDto> getAllLevels() {
        return difficultyLevelService.getAllLevels();
    }

    @GetMapping(value = "/getAllLevelsByPage", produces = APPLICATION_JSON_VALUE)
    public Page<DifficultyLevelDto> getAllLevelsByPage(Pageable pageable) {
        return difficultyLevelService.getAllByPage(pageable);
    }

    @PostMapping(value = "/updateLevel", produces = APPLICATION_JSON_VALUE)
    public void updateLevel(@RequestBody DifficultyLevelDto difficultyLevelDto) {
        difficultyLevelService.update(difficultyLevelDto);
    }

    @PutMapping(value = "/saveLevel", produces = APPLICATION_JSON_VALUE)
    public DifficultyLevelDto saveLevel(@RequestBody DifficultyLevelDto difficultyLevelDto) {
        return difficultyLevelService.save(difficultyLevelDto);
    }
}
