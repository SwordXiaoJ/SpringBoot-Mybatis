package com.example.demo.mapper;

import com.example.demo.pojo.StudentHomework;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

public interface StudentHomeworkMapper {

    List<StudentHomework> selectAll();
    void addStudentHomework(@Param("id") Integer id,@Param("home_id") Integer home_id,@Param("stu_id") Integer stu_id, @Param("title") String title, @Param("content") String content, @Param("create_time") Timestamp create_time, @Param("update_time") Timestamp update_time);
    List<StudentHomework> selectmy(String my_id);
    List<StudentHomework> selectbystu(String stu_id);
    List<StudentHomework> selectbyhome(String home_id);
    List<StudentHomework> selectbycross(String stu_id,String home_id);
}
