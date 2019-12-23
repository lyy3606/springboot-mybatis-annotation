package com.imooc.demo.dao;

import com.imooc.demo.entity.StudentInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentDaoTest {
    @Autowired
    private StudentDao studentDao;

    @Test
    void queryStudentInfo() {
        List<StudentInfo> list = studentDao.queryStudentInfo();
        assertEquals(5,list.size());
    }

    @Test
    void queryStudentInfoById() {
        StudentInfo studentInfo = studentDao.queryStudentInfoById(2);
        System.out.println(studentInfo);
        assertEquals("小明",studentInfo.getName());
    }

    @Test
    void insertStudent() {
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setName("小芳");
        studentInfo.setAge(20);
        studentInfo.setGender("女");
        studentInfo.setGrade("一年级");
        studentInfo.setPrefession("财务管理");
        studentInfo.setHobby("跳舞");
        int effectedNum = studentDao.insertStudent(studentInfo);
        assertEquals(1,effectedNum);
    }

    @Test
    void updateStudent() {
        StudentInfo info = new StudentInfo();
        info.setId(7);
        info.setName("jack");
        info.setAge(23);
        info.setGender("男");
        info.setGrade("三年级");
        info.setHobby("游泳");
        info.setPrefession("通信工程");
        int effectedNum = studentDao.updateStudent(info);
        assertEquals(1,effectedNum);
    }

    @Test
    void deleteStudent() {
        int effectedNum = studentDao.deleteStudent(7);
        assertEquals(1,effectedNum);
    }
}