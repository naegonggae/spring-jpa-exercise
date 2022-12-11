package com.jpa.exercise.domain.dto;

import com.jpa.exercise.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class HospitalItemResponse {
    private Integer id;
    private String roadNameAddress;
    private String hospitalName;
    private List<ReviewResponse> reviews;
}
