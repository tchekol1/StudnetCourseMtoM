package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @RequestMapping("/")
    public String index(Model model){
        Set<Student> students= new HashSet<>();
        Set<Course> courses= new HashSet<>();
        Student student1= new Student();
        student1.setName("Tewolgn");
        student1.setDepartment("Information Systems");
        student1.setGpa(3.7);
        Course course1 = new Course();
        course1.setTitle("Java101");
        course1.setCredits(4);
        course1.setInstructor("Sue");
        students.add(student1);
        courses.add(course1);
        student1.setCourses(courses);
        course1.setStudents(students);
        studentRepository.save(student1);
        courseRepository.save(course1);

        Course course2= new Course();
        course2.setTitle("Html101");
        course2.setInstructor("Joe");
        course2.setCredits(4);
        course2.setStudents(students);
        courseRepository.save(course2);
        model.addAttribute("students",studentRepository.findAll());
        for(Student s:studentRepository.findAll()){
            System.out.println(s.getName());
        }
        //model.addAttribute("courses",courseRepository.findAll());
        return "index";



    }
}

