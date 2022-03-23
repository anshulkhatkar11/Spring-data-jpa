package com.anshul.Springdatajpa.repository;

import com.anshul.Springdatajpa.entity.Guardian;
import com.anshul.Springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("anshul@gmaill.com")
                .firstName("Anshul")
                .lastName("Arya")
                //.guardianName("Yash")
                //.guardianEmail("yash@gmail.com")
                //.guardianMobile("9999999999")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .email("nikhil@gmail.com")
                .name("nikhil")
                .mobile("99999912")
                .build();

        Student student=Student.builder()
                .firstName("Shivam")
                .emailId("shivam@gmail.com")
                .lastName("Kumar")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList= studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students=
                studentRepository.findByFirstName("Shivam");
        System.out.println(students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students=
                studentRepository.findByFirstNameContaining("An");
        System.out.println(students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students=
                studentRepository.findByGuardianName("Yash");
        System.out.println(students);
    }

    @Test
    public void printgetStudentByEmailAddress(){
        String student=
                studentRepository.
                        getStudentFirstNameByEmailAddress(
                          "anshul@gmaill.com"
                        );
        System.out.println(student);
    }

    @Test
    public void printgetStudentByEmailAddressNative(){
        Student student=
                studentRepository.getStudentByEmailAddressNative("shivam@gmail.com");
        System.out.println(student);
    }

    public void printgetStudentByEmailAddressNativeAddressParam(){
        Student student=
                studentRepository.getStudentByEmailAddressNativeNamedParam(
                        "shivam@gmail.com"
                );
        System.out.println(student);
    }

}