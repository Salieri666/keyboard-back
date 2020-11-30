package com.sisprog.keyboard.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "zone")
@NoArgsConstructor
@AllArgsConstructor
public class Zone {

    @Id
    private Long id;

    private String symbols;
}
