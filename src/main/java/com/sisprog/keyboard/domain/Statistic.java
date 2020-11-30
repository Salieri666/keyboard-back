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
    private long id;

    @Column(name = "max_speed")
    private int maxSpeed;

    @Column(name = "avg_speed")
    private int avgSpeed;

    private int errors;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_execution")
    private Date dateExecution;

    @Column(name = "number_of_executions")
    private int numberOfExecutions;

    @Column(name = "number_of_failures")
    private int numberOfFailures;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "exercise_id")
    private long exerciseId;
}
