package com.sisprog.keyboard.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "statistic")
@NoArgsConstructor
@AllArgsConstructor
public class Statistic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "max_speed")
    private Integer maxSpeed;

    @Column(name = "avg_speed")
    private Integer avgSpeed;

    private Integer errors;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_execution")
    private Date dateExecution;

    @Column(name = "number_of_executions")
    private Integer numberOfExecutions;

    @Column(name = "number_of_failures")
    private Integer numberOfFailures;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "exercise_id")
    private Long exerciseId;
}
