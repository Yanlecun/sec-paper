package com.sp.fc.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="sp_user")
public class User implements UserDetails {  // 시큐리티(DaoAuthProvider)가 사용하는 UserDetails

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name = "userId"))
    private Set<Authority> authorities; // 권한 객체를 직접 갖고 있음

    private String grade;

    @ManyToOne(fetch = FetchType.EAGER)
    private User teacher;

    @ManyToOne(fetch = FetchType.EAGER)
    private School school;

    private boolean enabled; // 계정, 자격 NonExpired, 계정 NonLocked를 변수 하나로 관리

    @Column(updatable = false)
    private LocalDateTime created;

    private LocalDateTime updated;


    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return enabled;
    }

}
