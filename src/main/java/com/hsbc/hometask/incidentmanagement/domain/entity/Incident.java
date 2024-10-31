package com.hsbc.hometask.incidentmanagement.domain.entity;

import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Incident {
    private UUID id;

    @NotBlank(message = "Title cannot be empty")
    private String title;

    private String description;

    private Integer status;
}

