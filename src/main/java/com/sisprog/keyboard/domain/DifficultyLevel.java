package com.sisprog.keyboard.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "difficulty_level")
@NoArgsConstructor
@AllArgsConstructor
public class DifficultyLevel {

    @Id
    private Long id;

    private String name;

    @Column(name = "max_length")
    private Integer maxLength;

    @Column(name = "min_length")
    private Integer minLength;

    @Column(name = "max_errors")
    private Integer maxErrors;

    @Column(name = "time_press")
    private Integer timePress;

    @Column(name = "zone_id")
    private Long zoneId;
}
