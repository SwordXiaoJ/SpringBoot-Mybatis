package com.example.demo.mapper;

import com.example.demo.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

public interface StudentMapper {

    List<Student> selectAllStu();
    void addStudent(@Param("student_id") Integer stu_id, @Param("name") String username,
                    @Param("create_time") Timestamp create_time, @Param("update_time") Timestamp update_time);
}
