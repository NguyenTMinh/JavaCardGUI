/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author DELL
 */
public class Xe {
    public static final int DANG_GUI_STATUS = 0; // xe dang duoc gui o bai
    public static final int KHONG_GUI_STATUS = 1; // xe dang khong duoc gui o bai
    
    private int id;
    private String tenhangxe;
    private String mausac;
    private String bienso;
    private int idSV;
    private int status;

    public Xe(int id, String tenhangxe, String mausac, String bienso, int idSV, int status) {
        this.id = id;
        this.tenhangxe = tenhangxe;
        this.mausac = mausac;
        this.bienso = bienso;
        this.idSV = idSV;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenhangxe() {
        return tenhangxe;
    }

    public void setTenhangxe(String tenhangxe) {
        this.tenhangxe = tenhangxe;
    }

    public String getMausac() {
        return mausac;
    }

    public void setMausac(String mausac) {
        this.mausac = mausac;
    }

    public String getBienso() {
        return bienso;
    }

    public void setBienso(String bienso) {
        this.bienso = bienso;
    }

    public int getIdSV() {
        return idSV;
    }

    public void setIdSV(int idSV) {
        this.idSV = idSV;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
