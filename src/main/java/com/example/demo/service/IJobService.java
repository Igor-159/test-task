package com.example.demo.service;

import com.example.demo.model.Job;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface IJobService {

    Map<String, Long> store(List<Job> jobs, LocalDateTime time);

    List<Job> find(final String device,
                   final String user,
                   final String type,
                   final LocalDateTime from,
                   final LocalDateTime to);
}
