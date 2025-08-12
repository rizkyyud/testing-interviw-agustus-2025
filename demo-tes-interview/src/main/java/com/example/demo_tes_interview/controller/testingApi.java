package com.example.demo_tes_interview.controller;

import com.example.demo_tes_interview.model.ApiResult;
import com.example.demo_tes_interview.model.PageRespown;
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

    @GetMapping
    public ResponseEntity<PageRespown<ApiResult>> list(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) @Min(1) @Max(100) Integer size,
            @RequestParam(required = false) Long userId
    ){
        return ResponseEntity.ok(service.list(page,size,userId));
    }
}
