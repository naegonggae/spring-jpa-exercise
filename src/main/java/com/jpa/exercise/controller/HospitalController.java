package com.jpa.exercise.controller;

import com.jpa.exercise.domain.dto.HospitalItemResponse;
import com.jpa.exercise.domain.dto.ReviewCreateRequest;
import com.jpa.exercise.domain.dto.ReviewCreateResponse;
import com.jpa.exercise.service.HospitalService;
import com.jpa.exercise.service.ReviewService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalController {
    private final HospitalService hospitalService;
    private final ReviewService reviewService;

    public HospitalController(HospitalService hospitalService, ReviewService reviewService) {
        this.hospitalService = hospitalService;
        this.reviewService = reviewService;
    }

    @PostMapping("/{id}/reviews")
    public ResponseEntity<ReviewCreateResponse> get(@PathVariable Integer id, @RequestBody ReviewCreateRequest reviewCreateRequest) {
        return ResponseEntity.ok().body(reviewService.add(reviewCreateRequest));
    }

    @GetMapping("")
    public ResponseEntity<List<HospitalItemResponse>> list(Pageable pageable) {
        return ResponseEntity.ok().body(new ArrayList<>());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalItemResponse> get(@PathVariable Integer id) {
        return ResponseEntity.ok().body(hospitalService.findById(id));
    }
}
