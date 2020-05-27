package com.example.demo.service.impl;

import com.example.demo.mapper.StudentHomeworkMapper;
import com.example.demo.pojo.StudentHomework;
import com.example.demo.service.StudentHomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
@Service
public class StudentHomeworkServiceImpl implements StudentHomeworkService {
    @Autowired
    private StudentHomeworkMapper studentHomeworkMapper;


    @Override
    public List<StudentHomework> selectAll() {
        return this.studentHomeworkMapper.selectAll();

    }

    @Override
    public void addStudentHomework(Integer id, Integer home_id, Integer stu_id, String title, String content, Timestamp create_time, Timestamp update_time) {
        create_time=new Timestamp(System.currentTimeMillis());
        update_time=create_time;
        this.studentHomeworkMapper.addStudentHomework(id, home_id, stu_id, title, content, create_time, update_time);
    }

    @Override
    public List<StudentHomework> selectmy(String my_id) {

        return this.studentHomeworkMapper.selectmy(my_id);
    }

    @Override
    public List<StudentHomework> selectbystu(String stu_id) {
        return this.studentHomeworkMapper.selectbystu(stu_id);
    }

    @Override
    public List<StudentHomework> selectbyhome(String home_id) {
        return this.studentHomeworkMapper.selectbyhome(home_id);
    }

    @Override
    public List<StudentHomework> selectbycross(String stu_id, String home_id) {
        return this.studentHomeworkMapper.selectbycross(stu_id,home_id);
    }
}
