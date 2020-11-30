package com.sisprog.keyboard.service;

import com.sisprog.keyboard.dto.ZoneDto;

import java.util.List;

public interface ZoneService {

    ZoneDto getZoneById(Long id);

    List<ZoneDto> getAllZone();

    ZoneDto save(ZoneDto zone);

    void update(ZoneDto zone);

    void delete(Long id);
}
