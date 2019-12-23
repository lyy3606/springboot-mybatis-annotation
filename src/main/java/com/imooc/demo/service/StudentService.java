package com.imooc.demo.service;

import com.imooc.demo.entity.StudentInfo;

import java.util.List;

public interface StudentService {
    /*
    查询全部学生信息
     */
    List<StudentInfo> queryStudentInfo();
    /*
    根据id查询学生信息
     */
    StudentInfo queryStudentById(int id);
    /*
    插入学生信息
     */
    boolean insertStudent(StudentInfo studentInfo);
    /*
    更新学生信息
     */
    boolean updateStudent(StudentInfo studentInfo);
    /*
    删除学生信息
     */
    boolean deleteStudent(int id);
}
