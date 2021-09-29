package com.sp.fc.user.service;

import com.sp.fc.user.domain.School;
import com.sp.fc.user.repository.SchoolRepository;
import com.sp.fc.user.service.helper.SchoolTestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest // db의 데이터 넣고 빼는 테스트임
public class SchoolTest {
    @Autowired
    private SchoolRepository schoolRepository; // DataJpaTest 덕분에 Autowired 없어도 주입된다.

    private SchoolService schoolService;
    private SchoolTestHelper schoolTestHelper;
    School school;

    @BeforeEach
    void before() {
        this.schoolRepository.deleteAll(); // 테스트가 반복되면 문제생길 수 있음
        this.schoolService = new SchoolService(schoolRepository);
        this.schoolTestHelper = new SchoolTestHelper(schoolService);
        school = this.schoolTestHelper.createSchool("테스트 학교", "서울");
    }

    @DisplayName("1. 학교를 생성")
    @Test
    void test_1() {
        List<School> list = schoolRepository.findAll();

        assertEquals(1, list.size());
        schoolTestHelper.assertSchool(list.get(0), "테스트 학교", "서울");
        //assertEquals("테스트 학교", list.get(0).getName());
        //assertEquals("서울", list.get(0).getCity());
    }   

    @DisplayName("2. 학교 이름을 수정한다")
    @Test
    void test_2(){
        schoolService.updateName(school.getSchoolId(), "테스트2 학교");
        assertEquals("테스트2 학교", schoolRepository.findAll().get(0).getName());
    }
    
    @DisplayName("3. 지역 목록을 가져온다")
    @Test
    void test_3(){
        List<String> list = schoolService.cities();
        assertEquals(1, list.size());
        assertEquals("서울", list.get(0));

        schoolTestHelper.createSchool("부산 학교", "부산");
        list = schoolService.cities();
        assertEquals(2, list.size());
    }
    
    @DisplayName("4. 지역으로 학교 목록을 가져오기")
    @Test
    void test_4(){
        List<School> list = schoolService.findAllByCity("서울");
        assertEquals(1, list.size());
    }
    
    
    //지역 목록을 가져오기
    //지역으로 학교 목록을 가져오기
}

