package com.sisprog.keyboard.service;

import com.sisprog.keyboard.dao.StatisticDao;
import com.sisprog.keyboard.dto.StatisticDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StatisticServiceImpl implements StatisticService {
    private final StatisticDao statisticDao;

    @Override
    public StatisticDto getById(Long id) {
        return StatisticDto.of(statisticDao.getOne(id));
    }

    @Override
    public List<StatisticDto> getAll() {
        return statisticDao.findAll().stream().map(StatisticDto::of).collect(Collectors.toList());
    }

    @Override
    public StatisticDto save(StatisticDto s) {
        return StatisticDto.of(statisticDao.save(StatisticDto.of(s)));
    }

    @Override
    public void update(StatisticDto s) {
        statisticDao.save(StatisticDto.of(s));
    }

    @Override
    public void delete(Long id) {
        statisticDao.deleteById(id);
    }

    @Override
    public Page<StatisticDto> getAllByPage(Pageable pageable) {
        return statisticDao.findAll(pageable).map(StatisticDto::of);
    }
}
