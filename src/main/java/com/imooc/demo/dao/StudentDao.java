package com.imooc.demo.dao;

import com.imooc.demo.entity.StudentInfo;

import java.util.List;

public interface StudentDao {
    /*
    查询全部学生信息
     */
    List<StudentInfo> queryStudentInfo();
    /*
    根据id查询学生信息
     */
    StudentInfo queryStudentInfoById(int studentId);
    /*
    插入一条学生数据
     */
    int insertStudent(StudentInfo studentInfo);
    /*
    更新一条学生数据
     */
    int updateStudent(StudentInfo studentInfo);
    /*
    删除一条学生数据
     */
    int deleteStudent(int id);
}
