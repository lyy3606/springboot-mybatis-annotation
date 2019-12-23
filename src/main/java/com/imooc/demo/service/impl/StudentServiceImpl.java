package com.imooc.demo.service.impl;

import com.imooc.demo.dao.StudentDao;
import com.imooc.demo.entity.StudentInfo;
import com.imooc.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public List<StudentInfo> queryStudentInfo() {
        System.out.println("studentDao:"+studentDao.queryStudentInfo());
        return studentDao.queryStudentInfo();
    }

    @Override
    public StudentInfo queryStudentById(int id) {
        return studentDao.queryStudentInfoById(id);
    }

    @Transactional
    @Override
    public boolean insertStudent(StudentInfo studentInfo) {
        if (studentInfo.getName() != null && !studentInfo.getName().equals("")){
            try{
                int effectedNum = studentDao.insertStudent(studentInfo);
                if (effectedNum>0){
                    return true;
                }else {
                    throw  new RuntimeException("添加学生信息失败");
                }
            }catch (Exception e){
                throw new RuntimeException("添加学生信息失败");
            }
        }else {
            throw  new RuntimeException("学生姓名不能为空");
        }
    }

    @Override
    @Transactional
    public boolean updateStudent(StudentInfo studentInfo) {
        if (studentInfo.getName() != null && !studentInfo.getName().equals("")){
            try{
                int effectedNum = studentDao.updateStudent(studentInfo);
                if (effectedNum>0){
                    return true;
                }else {
                    throw  new RuntimeException("更新学生信息失败");
                }
            }catch (Exception e){
                throw new RuntimeException("更新学生信息失败");
            }
        }else {
            throw  new RuntimeException("学生姓名不能为空");
        }
    }

    @Override
    @Transactional
    public boolean deleteStudent(int id) {
            try{
                int effectedNum = studentDao.deleteStudent(id);
                if (effectedNum>0){
                    return true;
                }else {
                    throw  new RuntimeException("删除学生信息失败");
                }
            }catch (Exception e){
                throw new RuntimeException("删除学生信息失败");
            }
    }
}
