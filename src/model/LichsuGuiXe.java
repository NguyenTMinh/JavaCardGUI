/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author anhgi
 */
public class LichsuGuiXe {
    private int id;
    private int idsinhvien;
    private String name;
    private String studentId;
    private String bienso;
    private String mausac;
    private Timestamp date;
    private int chieu; // 2 gia tri 0 va 1, 0 la GUI XE, 1 la LAY XE

    public LichsuGuiXe(int id, int idsinhvien, String name, String studentId, String bienso, String mausac, Timestamp date, int chieu) {
        this.id = id;
        this.idsinhvien = idsinhvien;
        this.name = name;
        this.studentId = studentId;
        this.bienso = bienso;
        this.mausac = mausac;
        this.date = date;
        this.chieu = chieu;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdsinhvien() {
        return idsinhvien;
    }

    public void setIdsinhvien(int idsinhvien) {
        this.idsinhvien = idsinhvien;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getChieu() {
        return chieu;
    }

    public void setChieu(int chieu) {
        this.chieu = chieu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getBienso() {
        return bienso;
    }

    public void setBienso(String bienso) {
        this.bienso = bienso;
    }

    public String getMausac() {
        return mausac;
    }

    public void setMausac(String mausac) {
        this.mausac = mausac;
    }

    @Override
    public String toString() {
        return "LichsuGuiXe{" + "id=" + id + ", idsinhvien=" + idsinhvien + ", name=" + name + ", studentId=" + studentId + ", bienso=" + bienso + ", mausac=" + mausac + ", date=" + date + ", chieu=" + chieu + '}';
    }
    
    
}
