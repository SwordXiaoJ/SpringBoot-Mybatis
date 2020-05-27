package com.example.demo.controller;

import com.example.demo.pojo.NeedHomework;
import com.example.demo.pojo.StudentHomework;
import com.example.demo.service.NeedHomeworkService;
import com.example.demo.service.StudentHomeworkService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
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

    @RequestMapping("/login")
    public String Login(){
        return "Student/StudentLogin";
    }
    @RequestMapping("/stuOperation")
    public String StuOperation(){
        return "Student/StudentOperation";
    }
    @RequestMapping("/myhomework")
    public String MyHomework(HttpServletRequest request,Model model){
        String nInfo=null;
        Cookie[] cookies=request.getCookies();
        for(Cookie cookie: cookies)
        {
            nInfo = cookie.getValue();
        }



        List<StudentHomework> list = studentHomeworkService.selectmy(nInfo);
        System.out.println(list);
        model.addAttribute("list",list);
        return "ShowAllHome";
    }
    @RequestMapping("/needhomework")
    public String NeedHomwork(Model model){
        List<NeedHomework> needlist = needHomeworkService.selectAllNeed();
        model.addAttribute("list",needlist);
        return "ShowAllNeed";
    }
    @RequestMapping("/submithome")
    public String submithome() {
        return "Student/SubmitHome";
    }

    @RequestMapping("/aftersubmithome")
    public String  aftersubmithome(Integer id, Integer h_id, Integer s_id, String h_title,
                                String h_content, Timestamp create_time, Timestamp update_time, Model model){
        List<StudentHomework> temp = studentHomeworkService.selectAll();
        int allid=temp.size();
        allid+=1;

        String allidstr=String.valueOf(allid);

        id  = Math.toIntExact(Long.parseLong(allidstr));

        studentHomeworkService.addStudentHomework(id, h_id, s_id, h_title, h_content, create_time, update_time);

        List<StudentHomework> stuhomework_list = this.studentHomeworkService.selectAll();

        model.addAttribute("list",stuhomework_list);
        return "ShowAllHome";
    }

}
