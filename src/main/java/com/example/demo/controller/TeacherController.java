package com.example.demo.controller;

import com.example.demo.pojo.NeedHomework;
import com.example.demo.pojo.Student;
import com.example.demo.pojo.StudentHomework;
import com.example.demo.service.NeedHomeworkService;
import com.example.demo.service.StudentHomeworkService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private NeedHomeworkService needHomeworkService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentHomeworkService studentHomeworkService;

    /**
     * restful风格跳转页面
     * @param page
     * @return
     */
    @RequestMapping("/{page}")
    public String execute(@PathVariable String page){
        return page;
    }

    @RequestMapping("/teaOperation")
    public String TeaOperation(){
        return "Teacher/TeacherOperation";
    }
    @RequestMapping("/addneed")
    public String AddNeed(){
        return "Teacher/AddNeedHomework";
    }

    @RequestMapping("/afteraddneed")
    public String  AfterAddNeed(Integer h_id, String h_title, String h_content, Timestamp create_time, Timestamp update_time,Model model){
        needHomeworkService.addNeedHomework(h_id, h_title, h_content, create_time, update_time);
        List<NeedHomework> needhomework_list=this.needHomeworkService.selectAllNeed();
        model.addAttribute("list",needhomework_list);
        return "ShowAllNeed";
    }

    @RequestMapping("/addstu")
    public String AddStu(){

        return "Teacher/AddStudent";
    }

    @RequestMapping("/afteraddstu")
    public String  AfterAddStu(Integer s_id, String s_name, Timestamp create_time, Timestamp update_time, Model model){
        System.out.println(s_id);
        System.out.println(s_name);
        studentService.addStudent(s_id,s_name,create_time,update_time);
        List<Student> student_list=this.studentService.selectAllStu();
        model.addAttribute("list",student_list);
        return "ShowAllStu";
    }
    @RequestMapping("/searchbycon")
    public String SearchByCon(){
        return "Teacher/SearchByCond";
    }

    @RequestMapping("/aftersearch")
    public String AfterSearch(Model model,String seastu_id,String seahome_id){

        List<StudentHomework> list=null;


        if(seastu_id=="")
        {
            list= studentHomeworkService.selectbyhome(seahome_id);

        }else if(seahome_id=="")
        {
            list = studentHomeworkService.selectbystu(seastu_id);
        }
        else
        {
            list = studentHomeworkService.selectbycross(seastu_id,seahome_id);
        }

        model.addAttribute("list",list);

        if(null == list || list.size() <= 0)
        {
            model.addAttribute("error","没有查询到指定数据");
        }
        else
        {
            model.addAttribute("error","");
        }

        return "ShowAllHome";
    }

    @RequestMapping("/allhome")
    public String ShowAll(Model model) {
        List<StudentHomework> list = this.studentHomeworkService.selectAll();
        model.addAttribute("list",list);
        return "ShowAllHome";
    }


}
