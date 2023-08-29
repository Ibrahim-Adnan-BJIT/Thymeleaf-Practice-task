package com.example.thymeleafpractice.controller;

import com.example.thymeleafpractice.model.Student;
import com.example.thymeleafpractice.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DemoController {


    private StudentService studentService;


    public DemoController(StudentService studentService) {
        this.studentService = studentService;

    }

    @RequestMapping("/hello")
    public String sayHello(Model model)
    {
        Student myObject=new Student();
        model.addAttribute("students",myObject);

        return "hello";
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute("students") Student students,Model model) {
        // Process the submitted MyObject
       List<Student>countStudent= studentService.create(students);

        model.addAttribute("allStudents",countStudent);
        // Redirect to a success page
        return "allStudents";
    }

    @RequestMapping("/hello1")
    public String sayHello1(Model model)
    {
        Student myObject=new Student();
        model.addAttribute("students",myObject);

        return "newFile";
    }
    @RequestMapping("/hello2")
    public String sayHello2(Model model)
    {
        Student myObject=new Student();
        model.addAttribute("students",myObject);

        return "update";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("students") Student students,Model model) {
        // Process the submitted MyObject
        List<Student>countStudent=studentService.deleteStudent(students);

        model.addAttribute("allStudents",countStudent);
        // Redirect to a success page
        return "allStudents";
    }
    @PostMapping("/updateStudent")
    public String update(@ModelAttribute("students") Student students,@RequestParam String str, @RequestParam String dept,@RequestParam int a,Model model) {
        // Process the submitted MyObject
        Student q1=new Student(str,dept,a);
        /*System.out.println(str+" "+dept+" "+a);
        System.out.println(students.getName()+" "+students.getDepartment());*/
        List<Student>countStudent=studentService.updateStudent(students,q1);
     model.addAttribute("allStudents",countStudent);
        return "allStudents";
    }


}
