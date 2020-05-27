package com.example.demo.service.impl;


import com.example.demo.mapper.StudentMapper;
import com.example.demo.pojo.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> selectAllStu() {
        return this.studentMapper.selectAllStu();
    }

    @Override
    public void addStudent(Integer stu_id, String username, Timestamp create_time, Timestamp update_time) {
        create_time=new Timestamp(System.currentTimeMillis());
        update_time=create_time;
        this.studentMapper.addStudent(stu_id,username,create_time,update_time);

    }
}
