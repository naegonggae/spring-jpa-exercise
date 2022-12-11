package com.jpa.exercise.domain;

import com.jpa.exercise.domain.dto.ReviewCreateResponse;
import com.jpa.exercise.domain.dto.ReviewResponse;
import lombok.*;

import javax.persistence.*;
import java.util.Optional;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String content;
    private String userName;

    @ManyToOne // 양방향
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    public static Review of(Hospital hospital, String title, String content, String userName) {
        Review review = new Review();
        review.setHospital(hospital);
        review.setTitle(title);
        review.setContent(content);
        review.setUserName(userName);
        return review;
    }

    public static ReviewResponse getReviewResponse(Review review) {
        String userName = review.getUserName();
        if (userName == null) userName = "";
        return ReviewResponse.builder()
                .id(review.getId())
                .title(review.getTitle())
                .content(review.getContent())
                .userName(userName)
                .build();
    }
}

