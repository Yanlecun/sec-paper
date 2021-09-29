package com.sp.fc.user.domain;

import lombok.* ;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="sp_school")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schoolId;

    private String name;

    private String city;
    
    @Column(updatable = false) // 모아서 상위 객체로 모으기
    private LocalDateTime created;
    private LocalDateTime updated;
}
