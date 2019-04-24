package com.zwwhnly.springbootdemo.controller;

import com.zwwhnly.springbootdemo.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "test")
public class TestController {
    @GetMapping(value = "studentMan")
    public List<Student> getStudentManList() {
        Student student1 = new Student("stu1", 1, "男");
        Student student2 = new Student("stu2", 2, "男");
        Student student3 = new Student("stu3", 3, "男");

        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);

        return list;
    }

    @GetMapping(value = "studentWomen")
    public List<Student> getStudentWomenList() {
        Student student1 = new Student("stu4", 4, "女");
        Student student2 = new Student("stu5", 5, "女");
        Student student3 = new Student("stu6", 6, "女");

        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);

        return list;
    }
}
