package com.imooc.demo.entity;

public class StudentInfo {
    /*
    编号
     */
    private int id;
    /*
    姓名
     */
    private String name;
    /*
    年龄
     */
    private int age;
    /*
    性别
     */
    private String gender;
    /*
    专业
     */
    private String prefession;
    /*
    年级
     */
    private String grade;
    /*
    爱好
     */
    private String hobby;

    public StudentInfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPrefession() {
        return prefession;
    }

    public void setPrefession(String prefession) {
        this.prefession = prefession;
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


}
