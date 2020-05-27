package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


/**
 * @author XJ
 * @date 2020-4-12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private long stu_id;
    private String name;
    private Timestamp createTime;
    private Timestamp updateTime;


}