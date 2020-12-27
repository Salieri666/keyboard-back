package com.sisprog.keyboard.controller;

import com.sisprog.keyboard.dto.StatisticDto;
import com.sisprog.keyboard.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/statistic")
public class StatisticController {

    @Autowired
    private StatisticService statisticService;

    @DeleteMapping(value = "/deleteStatistic/{id}", produces = APPLICATION_JSON_VALUE)
    public void deleteStatistic(@PathVariable("id") Long id) {
        statisticService.delete(id);
    }

    @GetMapping(value = "/getStatistic/{id}", produces = APPLICATION_JSON_VALUE)
    public StatisticDto getStatistic(@PathVariable("id") Long id) {
        return statisticService.getById(id);
    }

    @GetMapping(value = "/getAllStatistics", produces = APPLICATION_JSON_VALUE)
    public List<StatisticDto> getAllStatistics() {
        return statisticService.getAll();
    }

    @GetMapping(value = "/getAllStatisticsByPage", produces = APPLICATION_JSON_VALUE)
    public Page<StatisticDto> getAllStatisticsByPage(Pageable pageable) {
        return statisticService.getAllByPage(pageable);
    }

    @PostMapping(value = "/updateStatistic", produces = APPLICATION_JSON_VALUE)
    public void updateStatistic(@RequestBody StatisticDto statisticDto) {
        statisticService.update(statisticDto);
    }

    @PutMapping(value = "/saveStatistic", produces = APPLICATION_JSON_VALUE)
    public StatisticDto saveStatistic(@RequestBody StatisticDto statisticDto) {
        return statisticService.save(statisticDto);
    }

    @GetMapping(value = "/getStatisticByUser/{userId}", produces = APPLICATION_JSON_VALUE)
    public List<StatisticDto> getStatisticByUser(@PathVariable("userId") Long userId) {
        return statisticService.getByUser(userId);
    }
}
