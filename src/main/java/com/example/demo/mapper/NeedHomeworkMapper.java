package com.example.demo.mapper;

import com.example.demo.pojo.NeedHomework;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

public interface NeedHomeworkMapper {
    List<NeedHomework> selectAllNeed();

    void addNeedHomework(@Param("homework_id") Integer id, @Param("title") String title,
                         @Param("content") String content, @Param("create_time") Timestamp create_time,@Param("update_time") Timestamp update_time);
}
