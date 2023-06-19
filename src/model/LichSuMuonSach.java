/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author Vanni
 */
public class LichSuMuonSach {
    private int id;
    private String maSach;
    private String tenSach;
    private int trangThai;
    private Date thoiGian;
    private String maSV;
    // them
    private int idSach;

    public LichSuMuonSach(int id, String maSach, String tenSach, int trangThai, Date thoiGian, String maSV) {
        this.id = id;
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.trangThai = trangThai;
        this.thoiGian = thoiGian;
        this.maSV = maSV;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public int getIdSach() {
        return idSach;
    }

    public void setIdSach(int idSach) {
        this.idSach = idSach;
    }

    @Override
    public String toString() {
        return "LichSuMuonSach{" + "id=" + id + ", maSach=" + maSach + ", tenSach=" + tenSach + ", trangThai=" + trangThai + ", thoiGian=" + thoiGian + ", maSV=" + maSV + ", idSach=" + idSach + '}';
    }
    
    
}
