package com.example.demo.mapping;

import com.example.demo.dto.JobsRequestDto;
import com.example.demo.model.Job;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface JobMapper {
    Job map(JobsRequestDto.JobDto entity);
}