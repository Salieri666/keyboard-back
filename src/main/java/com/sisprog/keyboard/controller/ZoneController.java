package com.sisprog.keyboard.controller;

import com.sisprog.keyboard.dto.ZoneDto;
import com.sisprog.keyboard.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping("/zone")
public class ZoneController {

    @Autowired
    private ZoneService zoneService;

    @DeleteMapping(value = "/deleteZone/{id}", produces = APPLICATION_JSON_VALUE)
    public void deleteZone(@PathVariable("id") Long id) {
        zoneService.delete(id);
    }

    @GetMapping(value = "/getZone/{id}", produces = APPLICATION_JSON_VALUE)
    public ZoneDto getZone(@PathVariable("id") Long id) {
        return zoneService.getZoneById(id);
    }

    @GetMapping(value = "/getAllZones", produces = APPLICATION_JSON_VALUE)
    public List<ZoneDto> getAllZones() {
        return zoneService.getAllZone();
    }

    @PostMapping(value = "/updateZone", produces = APPLICATION_JSON_VALUE)
    public void updateZone(@RequestBody ZoneDto zoneDto) {
        zoneService.update(zoneDto);
    }

    @PutMapping(value = "/saveZone", produces = APPLICATION_JSON_VALUE)
    public ZoneDto saveZone(@RequestBody ZoneDto zoneDto) {
        return zoneService.save(zoneDto);
    }

}
