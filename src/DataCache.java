
import model.SinhVien;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Lop dung de luu cache du lieu trong the tranh viec goi xuong the load data len qua nhieu, 
 * cac thong tin la cua the dang lam viec duoc thiet lap khi connect va xoa khi disconnect
 * @author DELL
 */
public class DataCache {
    private SinhVien sinhVien; // Luu thong tin doi tuong sinh vien the dang 

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }
    
    public void clear() {
        sinhVien = null;
    }
}
