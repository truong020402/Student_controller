package com.example.Student.controller;

import com.example.Student.model.Student;
import com.example.Student.payload.ResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class demoController {
    public List<Student> students = new ArrayList<>();


    @GetMapping("/{name}/{age}")
    public ResponseEntity<ResponseData> addByPathVariable(
            @PathVariable("name") String name,
            @PathVariable("age")  int  age
    ){
        ResponseData res = new ResponseData();
        res.setStatusCode(HttpStatus.OK.value());
        res.setSuccess(students!= null);
        Student s = new Student();
        s.setName(name);
        s.setAge(age);
        students.add(s);
        res.setData(students);
       return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @GetMapping("/api")
    public ResponseEntity<ResponseData> addByRequestParam(
            @RequestParam("name") String name,
            @RequestParam("age")  int age
    ){
        ResponseData res = new ResponseData();
        res.setStatusCode(HttpStatus.OK.value());
        res.setSuccess(students!=null);
        Student s = new Student();
        s.setName(name);
        s.setAge(age);
        students.add(s);
        res.setData(students);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseData> addByRawBody(@RequestBody Student s){
        students.add(s);
        ResponseData res = new ResponseData();
        res.setStatusCode(HttpStatus.OK.value());
        res.setSuccess(students!=null);
        res.setData(students);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
}
