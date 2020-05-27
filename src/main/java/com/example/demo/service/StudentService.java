package com.example.demo.service;

import com.example.demo.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

public interface StudentService {
    List<Student> selectAllStu();
    void addStudent(Integer stu_id, String username,
                    Timestamp create_time, Timestamp update_time);
}
