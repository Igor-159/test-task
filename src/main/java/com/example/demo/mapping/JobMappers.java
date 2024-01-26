package com.example.demo.mapping;

import com.example.demo.dto.JobsRequestDto;
import com.example.demo.model.Job;
import org.springframework.stereotype.Component;

@Component
public class JobMappers implements BaseMapper<JobsRequestDto.JobDto, Job> {

    @Override
    public Job map(final JobsRequestDto.JobDto source) {
        final Job job = new Job();
        job.setJobId(source.getId());
        job.setDevice(source.getDevice());
        job.setUser(source.getUser());
        job.setType(source.getType().getValue());
        job.setAmount(source.getAmount());
        return job;
    }
}
