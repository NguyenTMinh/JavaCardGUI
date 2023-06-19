/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Vanni
 */
public class Sach {
    public static final int KHONG_MUON_STATUS = 0; // xe dang duoc gui o bai
    public static final int DANG_MUON_STATUS = 1; // xe dang khong duoc gui o bai
    
    private int id;
    private String maSach;
    private String tenSach;
    private int trangThai;
    private String maSV;

    public Sach(int id, String maSach, String tenSach, int trangThai, String maSV) {
        this.id = id;
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.trangThai = trangThai;
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

     public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    @Override
    public String toString() {
        return "Sach{" + "id=" + id + ", maSach=" + maSach + ", tenSach=" + tenSach + ", trangThai=" + trangThai + ", maSV=" + maSV + '}';
    }
}
