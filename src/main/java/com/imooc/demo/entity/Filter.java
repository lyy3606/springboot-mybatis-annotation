package com.imooc.demo.entity;

import com.imooc.demo.annotion.Colnum;
import com.imooc.demo.annotion.Table;

@Table("student_info")
public class Filter {
    @Colnum("student_id")
    private int id;
    @Colnum("student_name")
    private String userName;
    @Colnum("student_age")
    private int age;
    @Colnum("student_genede")
    private String gender;
    @Colnum("student_prefession")
    private String prefession;
    @Colnum("student_grede")
    private String grade;
    @Colnum("student_hobby")
    private String hobby;


    public Filter() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getPrefession() {
        return prefession;
    }

    public void setPrefession(String prefession) {
        this.prefession = prefession;
    }
}
