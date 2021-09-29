package com.sp.fc.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "sp_authority")
@IdClass(Authority.class) // @Id를 여러 개 가질 경우
public class Authority implements GrantedAuthority {

    public static final String ROLE_TEACHER = "ROLE_TEACHER";
    public static final String ROLE_STUDENT = "ROLE_STUDENT";

    @Id
    private Long userId;  // 중복해서 부여되면 안 되는 것

    @Id
    private String authority; // 중복해서 부여되면 안 되는 것

}
