package com.example.Course.Registration.System.controller;

import com.example.Course.Registration.System.model.Course;
import com.example.Course.Registration.System.model.CourseRegistry;
import com.example.Course.Registration.System.repository.CourseRegistryRepo;
import com.example.Course.Registration.System.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("courses")
    public List<Course> availableCourses(){
        return courseService.availableCourses();
    }
    @GetMapping("courses/enrolled")
    public List<CourseRegistry> enrolledStudents(){
        return  courseService.enrolledStudents();
    }

    @PostMapping("courses/register")
    public  String enrollcourse(@RequestParam("name")String name,
                                @RequestParam("emailId")String emailId,
                                @RequestParam("courName")String courName){
        courseService.enrolledCourses(name,emailId,courName);
        return "Congratulation! "+name+"Enrollment Successful for "+courName;

    }
}
