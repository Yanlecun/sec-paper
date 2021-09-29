package com.sp.fc.paper.domain;

import com.sp.fc.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="sp_paper_template")
public class PaperTemplate {  // 선생님이 작성하는 시험지

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paperTemplateId;

    private String name;

    private Long userId;

    @Transient
    private User creator; // 유저 id를 이용해 찾은 map객체 사용

    private int total; // problemList 매번 가져오기는 데이터 이동이 커서 따로 정의..

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name="paperTemplateId"))
    private List<Problem> problemList; // 문제를 하나씩 추가한다.

    private long publishedCount;

    private long completeCount;

    @Column(updatable = false)
    private LocalDateTime created;

    private LocalDateTime updated;

}
