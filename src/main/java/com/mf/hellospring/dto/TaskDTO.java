package com.mf.hellospring.dto;

import jakarta.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record TaskDTO(Long id, @NotBlank String title, @Size(max = 200) String description) {
}