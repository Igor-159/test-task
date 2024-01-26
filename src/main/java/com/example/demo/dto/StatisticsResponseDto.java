package com.example.demo.dto;

import com.example.demo.utils.StatisticsLocalDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class StatisticsResponseDto {

    @JsonProperty(value = "jobId")
    private Long id;

    @JsonProperty(value = "device")
    private String device;

    @JsonProperty(value = "user")
    private String user;

    @JsonProperty(value = "type")
    private String type;

    @JsonProperty(value = "amount")
    private Long amount;

    @JsonSerialize(using = StatisticsLocalDateTimeSerializer.class)
    @JsonProperty(value = "time")
    private LocalDateTime time;






}
