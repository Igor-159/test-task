package com.example.demo.dto;


import com.example.demo.model.JobType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "jobs")
@XmlAccessorType(XmlAccessType.FIELD)
public class JobsRequestDto {

    @Valid
    @NotEmpty
    @XmlElement(name = "job")
    private List<JobDto> jobs;

    public List<JobDto> getJobs() {
        return jobs;
    }

    public void setJobs(final List<JobDto> jobs) {
        this.jobs = jobs;
    }

    @Data
    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    public static final class JobDto {

        @NotNull
        @XmlAttribute(name = "id")
        private Long id;

        @NotNull(message = "Unknown type")
        @XmlElement(name = "type")
        private JobTypeDto type;

        @NotBlank
        @XmlElement(name = "user")
        private String user;

        @NotBlank
        @XmlElement(name = "device")
        private String device;

        @Min(1)
        @XmlElement(name = "amount")
        private Long amount;


    }

    @XmlType
    @XmlEnum
    public enum JobTypeDto {
        @XmlEnumValue("print") PRINT(JobType.PRINT),
        @XmlEnumValue("copy") COPY(JobType.COPY),
        @XmlEnumValue("scan") SCAN(JobType.SCAN),
        @XmlEnumValue("fax") FAX(JobType.FAX);

        private final JobType value;

        JobTypeDto(final JobType value) {
            this.value = value;
        }

        public JobType getValue() {
            return value;
        }
    }

}
