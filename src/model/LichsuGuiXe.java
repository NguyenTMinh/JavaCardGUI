/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author anhgi
 */
public class LichsuGuiXe {
    private int id;
    private int idsinhvien;
    private Date date;
    private int chieu; // 2 gia tri 0 va 1, 0 la GUI XE, 1 la LAY XE
    
    public LichsuGuiXe(int id, int idsinhvien, Date date, int chieu) {
        this.id = id;
        this.idsinhvien = idsinhvien;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getChieu() {
        return chieu;
    }

    public void setChieu(int chieu) {
        this.chieu = chieu;
    }
    
    @Override
     public String toString() {
        return "Lichsu{"+ id + idsinhvien + date + '"' + '}' ;
    }
}
