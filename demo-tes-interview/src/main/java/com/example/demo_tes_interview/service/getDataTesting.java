package com.example.demo_tes_interview.service;

import com.example.demo_tes_interview.model.ApiResult;
import com.example.demo_tes_interview.model.PageRespown;
import org.springframework.stereotype.Service;

@Service
public interface getDataTesting {

    PageRespown<ApiResult> findAll(Long userId, int page, int size);
}
