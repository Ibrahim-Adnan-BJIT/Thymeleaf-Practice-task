package com.example.thymeleafpractice.service;

import com.example.thymeleafpractice.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private List<Student>countStudent;

    public StudentService(List<Student> countStudent) {
        this.countStudent = countStudent;
    }

    public List<Student> create(Student student)
   {
       countStudent.add(student);
       return countStudent;
   }
   public List<Student> deleteStudent(Student student)
   {
       countStudent.removeIf(s1 -> s1.getName().equals(student.getName()));

       return countStudent;
   }
   public List<Student> updateStudent(Student student1,Student student2)
   {
       for(Student st: countStudent)
       {
           if(st.getName().equals(student1.getName()))
           {
               st.setName(student2.getName());
               st.setDepartment(student2.getDepartment());
               st.setAge(student2.getAge());
           }
       }
        return countStudent;
   }

}
