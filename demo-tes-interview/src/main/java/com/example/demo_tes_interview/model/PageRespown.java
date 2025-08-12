package com.example.demo_tes_interview.model;

import java.util.List;

public record PageRespown <T>(
        List<T> data,
        Integer page,
        Integer size
) {
}
