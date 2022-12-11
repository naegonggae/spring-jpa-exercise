package com.jpa.exercise.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponse {
    private Integer id;
    private String title;
    private String content;
    private String userName;
}
