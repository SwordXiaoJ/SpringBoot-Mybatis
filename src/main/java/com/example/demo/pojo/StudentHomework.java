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
public class StudentHomework {

    private Long id;

    private Long studentId;

    private Long homeworkId;

    private String homeworkTitle;

    private String homeworkContent;

    private Timestamp createTime;

    private Timestamp updateTime;

}
