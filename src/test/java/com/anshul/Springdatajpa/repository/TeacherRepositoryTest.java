package com.anshul.Springdatajpa.repository;

import com.anshul.Springdatajpa.entity.Course;
import com.anshul.Springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course courseDBA = Course.builder()
                .title("DBA")
                .credit(7)
                .build();

        Course courseJava = Course.builder()
                .title("java")
                .credit(6)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Mridul")
                .lastName("gupta")
                //.courses(List.of(courseDBA,courseJava))
                .build();
        teacherRepository.save(teacher);

    }

}