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
    private long id;

    private String name;

    @Column(name = "max_length")
    private int maxLength;

    @Column(name = "min_length")
    private int minLength;

    @Column(name = "max_errors")
    private int maxErrors;

    @Column(name = "time_press")
    private int timePress;

    @Column(name = "zone_id")
    private long zoneId;
}
