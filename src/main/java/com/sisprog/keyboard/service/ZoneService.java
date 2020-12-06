package com.sisprog.keyboard.service;

import com.sisprog.keyboard.dto.ZoneDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ZoneService {

    ZoneDto getZoneById(Long id);

    List<ZoneDto> getAllZone();

    ZoneDto save(ZoneDto zone);

    void update(ZoneDto zone);

    void delete(Long id);

    Page<ZoneDto> getZoneByPage(Pageable pageable);
}
