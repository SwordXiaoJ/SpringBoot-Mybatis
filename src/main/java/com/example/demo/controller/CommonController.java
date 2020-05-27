package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

    /**
     * restful风格跳转页面
     * @param page
     * @return
     */
    @RequestMapping("/{page}")
    public String execute(@PathVariable String page){
        return page;
    }
}
