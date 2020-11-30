package com.sisprog.keyboard.service;

import com.sisprog.keyboard.dao.ZoneDao;
import com.sisprog.keyboard.dto.ZoneDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ZoneServiceImpl implements ZoneService{
    private final ZoneDao zoneDao;

    @Override
    public ZoneDto getZoneById(Long id) {
        return null;
    }

    @Override
    public List<ZoneDto> getAllZone() {
        return null;
    }

    @Override
    public ZoneDto save(ZoneDto zone) {
        return null;
    }

    @Override
    public void update(ZoneDto zone) {

    }

    @Override
    public void delete(Long id) {

    }
}
