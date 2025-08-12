package com.example.demo_tes_interview.service;

import com.example.demo_tes_interview.model.ApiResult;
import com.example.demo_tes_interview.model.PageRespown;
import org.springframework.stereotype.Service;

@Service
public interface GetDataService {

    PageRespown<ApiResult> find(int page, int size);
}
