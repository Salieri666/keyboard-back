package com.sisprog.keyboard.dto;

import com.sisprog.keyboard.domain.DifficultyLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DifficultyLevelDto {

    private Long id;
    private String name;
    private Integer maxLength;
    private Integer minLength;
    private Integer maxErrors;
    private Integer timePress;
    private Long zoneId;

    public static DifficultyLevelDto of(DifficultyLevel difficultyLevel) {
        DifficultyLevelDto levelDto = new DifficultyLevelDto();
        levelDto.setId(difficultyLevel.getId());
        levelDto.setName(difficultyLevel.getName());
        levelDto.setMaxLength(difficultyLevel.getMaxLength());
        levelDto.setMinLength(difficultyLevel.getMinLength());
        levelDto.setMaxErrors(difficultyLevel.getMaxErrors());
        levelDto.setTimePress(difficultyLevel.getTimePress());
        levelDto.setZoneId(difficultyLevel.getZoneId());
        return levelDto;
    }

    public static DifficultyLevel of(DifficultyLevelDto difficultyLevelDto) {
        DifficultyLevel level = new DifficultyLevel();
        level.setId(difficultyLevelDto.getId());
        level.setName(difficultyLevelDto.getName());
        level.setMaxLength(difficultyLevelDto.getMaxLength());
        level.setMinLength(difficultyLevelDto.getMinLength());
        level.setMaxErrors(difficultyLevelDto.getMaxErrors());
        level.setTimePress(difficultyLevelDto.getTimePress());
        level.setZoneId(difficultyLevelDto.getZoneId());
        return level;
    }
}
