package com.example.demo.service.impl;

import com.example.demo.model.Job;
import com.example.demo.repository.JobRepository;
import com.example.demo.repository.specification.*;
import com.example.demo.service.IJobService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class JobService implements IJobService {

    private final JobRepository jobRepository;

    @Transactional
    @Override
    public Map<String, Long> store(final List<Job> jobs, final LocalDateTime time) {
        jobs.forEach(job -> job.setTime(time));
        final List<Job> savedJobs = jobRepository.saveAll(jobs);
        return savedJobs.stream().collect(
                Collectors.groupingBy(Job::getUser, Collectors.summingLong(Job::getAmount)));
    }

    @Transactional
    @Override
    public List<Job> find(final String device,
                          final String user,
                          final String type,
                          final LocalDateTime from,
                          final LocalDateTime to) {
        final Specification<Job> specification =Specification.where(new JobByDevice(device))
                .and(new JobByUser(user))
                .and(new JobByType(type))
                .and(new JobByTimeFrom(from))
                .and(new JobByTimeTo(to));

        return jobRepository.findAll(specification, Sort.by(Sort.Direction.DESC, "time"));
    }
}
