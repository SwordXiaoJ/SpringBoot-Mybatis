package com.example.demo.service.impl;

import com.example.demo.mapper.NeedHomeworkMapper;
import com.example.demo.pojo.NeedHomework;
import com.example.demo.service.NeedHomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class NeedHomeworkServiceImpl implements NeedHomeworkService {
    @Autowired
    private NeedHomeworkMapper needHomeworkMapper;

    @Override
    public List<NeedHomework> selectAllNeed() {
        return this.needHomeworkMapper.selectAllNeed();
    }

    @Override
    public void addNeedHomework(Integer id, String title, String content, Timestamp create_time, Timestamp update_time) {
        create_time=new Timestamp(System.currentTimeMillis());
        update_time=create_time;
        this.needHomeworkMapper.addNeedHomework(id,title,content,create_time,update_time);

    }
}
