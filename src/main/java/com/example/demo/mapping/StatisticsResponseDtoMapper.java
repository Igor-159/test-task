package com.example.demo.mapping;


import com.example.demo.dto.StatisticsResponseDto;
import com.example.demo.model.Job;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatisticsResponseDtoMapper {
    StatisticsResponseDto map(Job source);

}
