package com.jpa.exercise.domain;

import com.jpa.exercise.domain.dto.HospitalItemResponse;
import com.jpa.exercise.domain.dto.HospitalResponse;
import com.jpa.exercise.domain.dto.ReviewCreateResponse;
import com.jpa.exercise.domain.dto.ReviewResponse;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode // 이건 왜쓰는거야
public class Hospital {
    @Id
    private Integer id;
    private String roadNameAddress;
    private String hospitalName;

    @OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY)
    private List<Review> reviews;

    public static HospitalResponse of(Hospital hospital) {
        return HospitalResponse.builder()
                .id(hospital.getId())
                .hospitalName(hospital.getHospitalName())
                .roadNameAddress(hospital.getRoadNameAddress())
                .build();
    }
    public static HospitalItemResponse ofSingle(Hospital hospital) {
        List<ReviewResponse> reviewResponses = hospital.getReviews().stream()
                .map(hospital1 -> Review.getReviewResponse(hospital1))
                .collect(Collectors.toList());
        return HospitalItemResponse.builder()
                .id(hospital.getId())
                .hospitalName(hospital.getHospitalName())
                .roadNameAddress(hospital.getRoadNameAddress())
                .reviews(reviewResponses)
                .build();
    }
}