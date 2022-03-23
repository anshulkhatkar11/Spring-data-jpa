package com.anshul.Springdatajpa.repository;

import com.anshul.Springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    //JPQL
    @Query("select s.firstName from Student s where s.emailId =?1")
    String getStudentFirstNameByEmailAddress(String emailid);

    //Native
    @Query(
            value="Select * From tbl_student s where s.email_address= ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailid);

    //Native Named Param
    @Query(
            value="Select * From tbl_student s where s.email_address= :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailid);
}
