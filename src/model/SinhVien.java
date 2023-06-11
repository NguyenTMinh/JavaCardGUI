/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author DELL
 */
public class SinhVien {
    private int id;
    private String avatar;
    private String name;
    private int gender;
    private Date date;
    private String phone;
    private String studentId;
    private String classSV;

    public SinhVien(int id, String avatar, String name, int gender, Date date, String phone, String studentId, String classSV) {
        this.id = id;
        this.avatar = avatar;
        this.name = name;
        this.gender = gender;
        this.date = date;
        this.phone = phone;
        this.studentId = studentId;
        this.classSV = classSV;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getClassSV() {
        return classSV;
    }

    public void setClassSV(String classSV) {
        this.classSV = classSV;
    }

    @Override
    public String toString() {
        return "SinhVien{" + "id=" + id + ", avatar=" + "..." + ", name=" + name + ", gender=" + gender + ", date=" + date + ", phone=" + phone + ", studentId=" + studentId + ", classSV=" + classSV + '}';
    }
}
