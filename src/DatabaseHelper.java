
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import model.LichSuMuonSach;
import model.Sach;
import model.SinhVien;
import model.Xe;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class DatabaseHelper {
//        private static final String DB_URL = "jdbc:mysql://localhost:3306/cardOs?ssl=true";
    private static final String DB_URL = "jdbc:mysql://localhost/cardOs";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "";
    
    // Sinh vien table
    private static final String TABLE_SINHVIEN = "sinhvien";
    private static final String COLUMN_ID_SINHVIEN = "id";
    private static final String COLUMN_AVATAR_SINHVIEN = "avatar";
    private static final String COLUMN_NAME_SINHVIEN = "name";
    private static final String COLUMN_GENDER_SINHVIEN = "gender";
    private static final String COLUMN_DATE_SINHVIEN = "date";
    private static final String COLUMN_PHONE_SINHVIEN = "phone";
    private static final String COLUMN_STUDENT_ID_SINHVIEN = "studentid";
    private static final String COLUMN_CLASS_SINHVIEN = "class";
    
//  Sach Table
    private static final String TABLE_SACH = "sach";
    private static final String COLUMN_ID_SACH = "id";
    private static final String COLUMN_MA_SACH= "masach";
    private static final String COLUMN_TEN_SACH = "tensach";
    private static final String COLUMN_TRANG_THAI = "trangthai";
    
//  Lich Su muon sach Table 
    private static final String TABLE_LICH_SU_MUON_SACH = "lichsumuonsach";
    private static final String COLUMN_ID_LICH_SU_MUON = "id";
    private static final String COLUMN_DATE_LICH_SU_MUON = "thoigian";
    
    // Xe table
    private static final String TABLE_XE = "xe";
    private static final String COLUMN_ID_XE = "id";
    private static final String COLUMN_TEN_XE = "tenhangxe";
    private static final String COLUMN_MAU_SAC = "mausac";
    private static final String COLUMN_BIEN_SO = "bienso";
    private static final String COLUMN_STATUS_XE = "status";
    private static final String COLUMN_ID_SV_REF = "idSV";
    
    private Connection connection;
    
    public DatabaseHelper() {
        connection = getConnection(DB_URL, USER_NAME, PASSWORD);
    }
    
    public static Connection getConnection(String dbURL, String userName, 
            String password) {
        Connection conn = null;
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
    
        public List<LichSuMuonSach> getAllHistory(){
        String findAllHistory = "SELECT * FROM " + TABLE_LICH_SU_MUON_SACH;
        List<LichSuMuonSach> mList = new ArrayList<>();
         try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(findAllHistory);
            
            while (resultSet.next()) {
                LichSuMuonSach history = new LichSuMuonSach(
                        resultSet.getInt(COLUMN_ID_LICH_SU_MUON), 
                     resultSet.getString(COLUMN_MA_SACH), 
                    resultSet.getString(COLUMN_TEN_SACH),
                   resultSet.getInt(COLUMN_TRANG_THAI),
                resultSet.getDate(COLUMN_DATE_LICH_SU_MUON),
                        resultSet.getString(COLUMN_STUDENT_ID_SINHVIEN));
                mList.add(history);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mList;
    }
    
    
    public List<Sach> getAllSach(){
        String findAllSinhVien = "SELECT * FROM " + TABLE_SACH;
        List<Sach> mList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(findAllSinhVien);
            
            while (resultSet.next()) {
                Sach sach = new Sach(
                        resultSet.getInt(COLUMN_ID_SACH), 
                     resultSet.getString(COLUMN_MA_SACH), 
                    resultSet.getString(COLUMN_TEN_SACH),
                   resultSet.getInt(COLUMN_TRANG_THAI));
                mList.add(sach);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mList;
    }
    

    public List<SinhVien> getAllSinhVien() {
        String findAllSinhVien = "SELECT * FROM " + TABLE_SINHVIEN;
        List<SinhVien> list = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(findAllSinhVien);


            while (resultSet.next()) {
                SinhVien sinhVien = new SinhVien(
                        resultSet.getInt(COLUMN_ID_SINHVIEN), 
                        resultSet.getString(COLUMN_AVATAR_SINHVIEN), 
                        resultSet.getString(COLUMN_NAME_SINHVIEN),
                        resultSet.getInt(COLUMN_GENDER_SINHVIEN), 
                        resultSet.getDate(COLUMN_DATE_SINHVIEN), 
                        resultSet.getString(COLUMN_PHONE_SINHVIEN), 
                        resultSet.getString(COLUMN_STUDENT_ID_SINHVIEN), 
                        resultSet.getString(COLUMN_CLASS_SINHVIEN));
                list.add(sinhVien);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
    
//    public List<Sach> findSachByName(String name){
//        //        SELECT * FROM your_table_name WHERE name_column LIKE 'A%;
//        
//        String findAllSinhVien = "SELECT * FROM " + TABLE_SACH;
//        List<Sach> mList = new ArrayList<>();
//        
//
//           
//
//
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(findAllSinhVien);
//            
//            while (resultSet.next()) {
//                Sach sach = new Sach(
//                        resultSet.getInt(COLUMN_ID_SACH), 
//                     resultSet.getString(COLUMN_MA_SACH), 
//                    resultSet.getString(COLUMN_TEN_SACH),
//                   resultSet.getInt(COLUMN_TRANG_THAI));
//                mList.add(sach);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return mList;
//    }
    
    public SinhVien findSinhVienById(int id) {

        String findSinhVien = "SELECT * FROM " + TABLE_SINHVIEN + " WHERE id=" + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(findSinhVien);
            SinhVien sinhVien = null;
            while (resultSet.next()) {
                sinhVien = new SinhVien(
                        resultSet.getInt(COLUMN_ID_SINHVIEN), 
                        resultSet.getString(COLUMN_AVATAR_SINHVIEN), 
                        resultSet.getString(COLUMN_NAME_SINHVIEN),
                        resultSet.getInt(COLUMN_GENDER_SINHVIEN), 
                        resultSet.getDate(COLUMN_DATE_SINHVIEN), 
                        resultSet.getString(COLUMN_PHONE_SINHVIEN), 
                        resultSet.getString(COLUMN_STUDENT_ID_SINHVIEN), 
                        resultSet.getString(COLUMN_CLASS_SINHVIEN));
            }
            
            return sinhVien;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public boolean updateSinhVien(SinhVien sinhVien) {
        SinhVien sv = findSinhVienById(sinhVien.getId());
        if (sv == null) {
            return false;
        }
        
        String updateQuery = "UPDATE " + TABLE_SINHVIEN + " SET " 
                + "avatar=" + "'" + sinhVien.getAvatar() + "'" + ","
                + "name="+ "'" + sinhVien.getName()+ "'" + ","
                + "gender=" + sinhVien.getGender() + ","
                + "date="+ "'" + sinhVien.getDate().toString()+ "'" + ","
                + "phone="+ "'" + sinhVien.getPhone()+ "'" + ","
                + "studentid="+ "'" + sinhVien.getStudentId()+ "'" + ","
                + "class="+ "'" + sinhVien.getClassSV()+ "' " + "WHERE id=" + sinhVien.getId();
        System.out.println(updateQuery);
        Statement statement;
        try {
            statement = connection.createStatement();
            int a = statement.executeUpdate(updateQuery);
            
            return a > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    // ---------- Xe -----------------------
    public Xe findXeBySinhVienId(int id) {
        String query = "SELECT * FROM " + TABLE_XE + " WHERE idSV=" + id;
        
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                Xe xe = new Xe(resultSet.getInt(COLUMN_ID_XE), 
                        resultSet.getString(COLUMN_TEN_XE), 
                        resultSet.getString(COLUMN_MAU_SAC), 
                        resultSet.getString(COLUMN_BIEN_SO), 
                        resultSet.getInt(COLUMN_STATUS_XE), 
                        resultSet.getInt(COLUMN_ID_SV_REF));
                return xe;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
