package com.example.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jobs", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"job_id", "device"})
})
public class Job {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "job_id", nullable = false)
    private Long jobId;

    @Column(name = "device", nullable = false)
    private String device;

    @Column(name = "user", nullable = false)
    private String user;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "type", nullable = false)
    private JobType type;

    @Column(name = "amount", nullable = false)
    private Long amount;

    @Column(name = "time", nullable = false)
    private LocalDateTime time;
}
