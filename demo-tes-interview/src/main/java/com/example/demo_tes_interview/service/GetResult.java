package com.example.demo_tes_interview.service;

import com.example.demo_tes_interview.model.ApiResult;
import com.example.demo_tes_interview.model.PageRespown;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetResult {

    private getDataTesting getData;
    public PageRespown<ApiResult>getResult(Integer page, Integer size, Long userId){

        var result = getData.findAll(userId, p, s);
        return new PageRespown<>(result,)
    }
}
