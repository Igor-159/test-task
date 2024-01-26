package com.example.demo.controllers;

import com.example.demo.dto.JobsRequestDto;
import com.example.demo.dto.StatisticsResponseDto;
import com.example.demo.mapping.JobMapper;
import com.example.demo.mapping.JobMappers;
import com.example.demo.mapping.StatisticsDtoMappers;
import com.example.demo.mapping.StatisticsResponseDtoMapper;
import com.example.demo.model.Job;
import com.example.demo.service.IJobService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/jobs")
public class JobController {

    private final IJobService jobService;

    private final JobMappers jobMapper;

    private final StatisticsDtoMappers statisticsDtoMapper;


    @PostMapping(
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    Map<String, String> addJob(@RequestBody @Valid JobsRequestDto request) {
        final LocalDateTime time = LocalDateTime.now();
        final List<Job> jobs = request.getJobs().stream()
                .map(jobMapper::map)
                .toList();
        final Map<String, Long> result = jobService.store(jobs, time);

        return result.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> String.valueOf(e.getValue())));
    }

    @GetMapping (value = "/statistics")
    List<StatisticsResponseDto> statistics(
            @RequestParam(value = "device", required = false) final String device,
            @RequestParam(value = "user", required = false) final String user,
            @RequestParam(value = "type", required = false) final String type,
            @RequestParam(value = "timeFrom", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) final LocalDateTime from,
            @RequestParam(value = "timeTo", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) final LocalDateTime to) {

        final List<StatisticsResponseDto> result = jobService.find(device, user, type, from, to).stream()
                .map(statisticsDtoMapper::map)
                .toList();
        return result;
    }



}
