package com.example.demo.service;

import com.example.demo.pojo.NeedHomework;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

public interface NeedHomeworkService {
    List<NeedHomework> selectAllNeed();

    void addNeedHomework(Integer id, String title,
                         String content, Timestamp create_time,Timestamp update_time);
}
