package com.sisprog.keyboard.dto;

import com.sisprog.keyboard.domain.Zone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZoneDto {

    private Long id;
    private String symbols;

    public static ZoneDto of(Zone zone) {
        ZoneDto zoneDto = new ZoneDto();
        zoneDto.setId(zone.getId());
        zoneDto.setSymbols(zone.getSymbols());
        return zoneDto;
    }

    public static Zone of(ZoneDto zoneDto) {
        Zone zone = new Zone();
        zone.setId(zoneDto.getId());
        zone.setSymbols(zoneDto.getSymbols());
        return zone;
    }
}
