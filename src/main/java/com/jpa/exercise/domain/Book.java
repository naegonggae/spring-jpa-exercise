package com.jpa.exercise.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    private Long id;
    private String name;
    //private Long authorId;

    @ManyToOne // 단방향 매핑
    @JoinColumn(name = "author_id") // join하면 FK 걸어
    private Author author;

    @OneToOne // 단방향 매핑
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;
}
