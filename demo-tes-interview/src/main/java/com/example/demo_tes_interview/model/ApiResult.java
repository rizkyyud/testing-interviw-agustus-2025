package com.example.demo_tes_interview.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ApiResult(
        long id,
        String title
) {
}
