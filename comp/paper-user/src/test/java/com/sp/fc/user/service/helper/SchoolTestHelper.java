package com.sp.fc.user.service.helper;

import com.sp.fc.user.domain.School;
import com.sp.fc.user.service.SchoolService;
import lombok.RequiredArgsConstructor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RequiredArgsConstructor
public class SchoolTestHelper {  // 테스트에 자주 이용되는 것들을 모아두기
    private final SchoolService schoolService;

    public static School makeSchool(String name, String city){
        School school = School.builder()
                .name(name)
                .city(city)
                .build();
        return school;
    }

    public School createSchool(String name, String city){
        return schoolService.save(makeSchool(name,city));
    }

    public static void assertSchool(School school, String name, String city) {
        assertNotNull(school.getSchoolId());
        assertNotNull(school.getCreated());
        assertNotNull(school.getUpdated());
        assertEquals(name, school.getName());
        assertEquals(city, school.getCity());
    }
}
