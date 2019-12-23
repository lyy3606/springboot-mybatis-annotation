package com.imooc.demo.web;

import com.imooc.demo.entity.StudentInfo;
import com.imooc.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/superadmin")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/liststudent",method = RequestMethod.GET)
    private Map<String,Object> listStudent(){
        Map<String,Object> modelMap = new HashMap<>();
        List<StudentInfo> list = studentService.queryStudentInfo();
        System.out.println(list);
        modelMap.put("data",list);
        return modelMap;
    }

    @RequestMapping(value = "/liststudentbyid",method = RequestMethod.GET)
    private Map<String,Object> listStudentById(Integer id){
        Map<String,Object> modelMap = new HashMap<>();
        StudentInfo studentInfo = studentService.queryStudentById(id);
        modelMap.put("data",studentInfo);
        return modelMap;
    }

    @RequestMapping(value = "/insertstudent",method = RequestMethod.POST)
    private Map<String,Object> insert(@RequestBody StudentInfo studentInfo){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",studentService.insertStudent(studentInfo));
        return modelMap;
    }

    @RequestMapping(value = "/updatestudent",method = RequestMethod.POST)
    private Map<String,Object> update(@RequestBody StudentInfo studentInfo){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",studentService.updateStudent(studentInfo));
        return modelMap;
    }

    @RequestMapping(value = "/deletestudent",method = RequestMethod.GET)
    private Map<String,Object> delete(Integer id){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",studentService.deleteStudent(id));
        return modelMap;
    }
}
