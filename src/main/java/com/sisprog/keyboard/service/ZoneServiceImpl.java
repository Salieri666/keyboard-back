package com.sisprog.keyboard.service;

import com.sisprog.keyboard.dao.ZoneDao;
import com.sisprog.keyboard.dto.ZoneDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ZoneServiceImpl implements ZoneService{
    private final ZoneDao zoneDao;

    @Override
    public ZoneDto getZoneById(Long id) {
        return ZoneDto.of(zoneDao.getOne(id));
    }

    @Override
    public List<ZoneDto> getAllZone() {
        return zoneDao.findAll().stream().map(ZoneDto::of).collect(Collectors.toList());
    }

    @Override
    public ZoneDto save(ZoneDto zone) {
        return ZoneDto.of(zoneDao.save(ZoneDto.of(zone)));
    }

    @Override
    public void update(ZoneDto zone) {
        zoneDao.save(ZoneDto.of(zone));
    }

    @Override
    public void delete(Long id) {
        zoneDao.deleteById(id);
    }

    @Override
    public Page<ZoneDto> getZoneByPage(Pageable pageable) {
        return zoneDao.findAll(pageable).map(ZoneDto::of);
    }
}
