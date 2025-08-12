package com.example.demo_tes_interview.controller;

import com.example.demo_tes_interview.model.ApiResult;
import com.example.demo_tes_interview.model.PageRespown;
import com.example.demo_tes_interview.service.GetDataService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/tes")
@RestController
@RequiredArgsConstructor
@Validated
public class testingApi {

    private final GetDataService getDataService;
    @GetMapping
    public ResponseEntity<PageRespown<ApiResult>> list(
            @RequestParam @Min(1) Integer page,
            @RequestParam @Min(1) @Max(100) Integer size
    ){
        return ResponseEntity.ok(getDataService.find(page, size));
    }
}
