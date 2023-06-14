
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import model.LichSuMuonSach;
import model.LichsuGuiXe;
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
    
    // lich su gui xe table
    private static final String TABLE_LICH_SU_XE = "lichsuguixe";
    private static final String COLUMN_LS_XE = "id";
    private static final String COLUMN_LS_XE_SV = "idsv";
    private static final String COLUMN_LS_THOI_GIAN = "thoigian";
    private static final String COLUMN_LS_CHIEU_XE = "chieu";
    
    // card
    private static final String TABLE_CARD = "card";
    private static final String COLUMN_ID_CARD = "id";
    private static final String COLUMN_MA_CARD = "mathe";
    private static final String COLUMN_ID_SV= "sv";
    
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
                        resultSet.getInt(COLUMN_TRANG_THAI),
                        resultSet.getString(COLUMN_STUDENT_ID_SINHVIEN));
                mList.add(sach);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mList;
    }
    
    public List<Sach> getSachChuaMuon() {
        String findSachChuaMuon = "SELECT * FROM " + TABLE_SACH + " WHERE " + COLUMN_TRANG_THAI + " = 0";
        List<Sach> mList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(findSachChuaMuon);

            while (resultSet.next()) {
                Sach sach = new Sach(
                        resultSet.getInt(COLUMN_ID_SACH),
                        resultSet.getString(COLUMN_MA_SACH),
                        resultSet.getString(COLUMN_TEN_SACH),
                        resultSet.getInt(COLUMN_TRANG_THAI),
                        resultSet.getString(COLUMN_STUDENT_ID_SINHVIEN));
                mList.add(sach);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(mList.size());

        return mList;
    }
    
     public List<Sach> getAllSachDuocMuon(SinhVien sinhVien) {
        String SachDuocMuon = "SELECT * FROM " + TABLE_SACH + " WHERE " + COLUMN_TRANG_THAI + " = 1 AND studentid = '" + sinhVien.getStudentId() + "'";
        List<Sach> mList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SachDuocMuon);

            while (resultSet.next()) {
                Sach sach = new Sach(
                        resultSet.getInt(COLUMN_ID_SACH),
                        resultSet.getString(COLUMN_MA_SACH),
                        resultSet.getString(COLUMN_TEN_SACH),
                        resultSet.getInt(COLUMN_TRANG_THAI),
                        resultSet.getString(COLUMN_STUDENT_ID_SINHVIEN));
                mList.add(sach);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mList;
    }
     
     public Sach findSachById(int id) {
        String findSach = "SELECT * FROM " + TABLE_SACH + " WHERE id = " + id;
        System.out.println(findSach);

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(findSach);
            Sach sach = null;
            while (resultSet.next()) {
                sach = new Sach(
                        resultSet.getInt(COLUMN_ID_SACH),
                        resultSet.getString(COLUMN_MA_SACH),
                        resultSet.getString(COLUMN_TEN_SACH),
                        resultSet.getInt(COLUMN_TRANG_THAI),
                        resultSet.getString(COLUMN_STUDENT_ID_SINHVIEN));
            }
            return sach;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
     public void traSach(Sach sach) {
        Sach s = findSachById(sach.getId());
        if (s == null) {
            System.out.println("Sach null");
            return;
        }

        String updateQuery = "UPDATE " + TABLE_SACH + " SET " + COLUMN_TRANG_THAI + " = 0, studentid = '' WHERE id = " + sach.getId();
        System.out.println("tra sach: " + updateQuery);
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(updateQuery);

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateMuonSach(Sach sach, SinhVien sinhVien) {
        Sach s = findSachById(sach.getId());
        if (s == null) {
            System.out.println("Sach null");
            return;
        }

        String updateQuery = "UPDATE " + TABLE_SACH + " SET " + COLUMN_TRANG_THAI + " = " + sach.getTrangThai() + ", studentid = '" + sinhVien.getStudentId() + "' WHERE id = " + sach.getId();
        System.out.println("Update muon sach: " + updateQuery);
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(updateQuery);

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void putUpdateToHistory(Sach sach, SinhVien sinhVien) {
        Sach s = findSachById(sach.getId());
        if (s == null) {
            return;
        }

        LocalDate currentDate = LocalDate.now();
        Date sqlDate = Date.valueOf(currentDate);
        System.out.println(sqlDate);
        String insertQuery = "INSERT INTO " + TABLE_LICH_SU_MUON_SACH + " ( masach, tensach, trangthai, thoigian, studentid) VALUE ( ?, ?, ?, ?, ?)";
        System.out.println(insertQuery);
        try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            statement.setString(1, sach.getMaSach());
            statement.setString(2, sach.getTenSach());
            statement.setInt(3, sach.getTrangThai());
            statement.setDate(4, sqlDate);
            statement.setString(5, sinhVien.getStudentId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // ========================== sv =================================
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
                        resultSet.getInt(COLUMN_ID_SV_REF), 
                        resultSet.getInt(COLUMN_STATUS_XE));
                return xe;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public void updateTrangThaiXe(int id, int trangThai) {
        String query = "UPDATE " + TABLE_XE + " SET " + COLUMN_STATUS_XE + "=" + trangThai
                + " WHERE id=" + id;
        try {
            Statement statement = connection.createStatement();
            int res = statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // ================ Lich su gui xe =====================
    public void addLogGuiXe(int chieu, SinhVien sv, Timestamp date) {
        String query = "INSERT INTO " + TABLE_LICH_SU_XE + " VALUE( NULL," 
                + sv.getId() + ",'" + date.toString() + "'," + chieu + ")";
        try {
            Statement statement = connection.createStatement();
            boolean res = statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<LichsuGuiXe> getLichsuGuiXes() {
        String query = "SELECT lichsuguixe.id as id, sinhvien.id as idsv,name,studentid,bienso,mausac, thoigian, "
                + "chieu FROM sinhvien JOIN xe ON sinhvien.id=idSV JOIN lichsuguixe ON sinhvien.id=lichsuguixe.idsv";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            List<LichsuGuiXe> list = new ArrayList<>();
            
            while (resultSet.next()) {
                LichsuGuiXe lichsuGuiXe = new LichsuGuiXe(resultSet.getInt("id"),
                        resultSet.getInt("idsv"), 
                        resultSet.getString(COLUMN_NAME_SINHVIEN),
                        resultSet.getString(COLUMN_STUDENT_ID_SINHVIEN), 
                        resultSet.getString(COLUMN_BIEN_SO), 
                        resultSet.getString(COLUMN_MAU_SAC), 
                        resultSet.getTimestamp(COLUMN_DATE_LICH_SU_MUON), 
                        resultSet.getInt(COLUMN_LS_CHIEU_XE));
                list.add(lichsuGuiXe);
            }
            
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    // =============== card ===================\
    public boolean isCardExisted(String mathe) {
        String query = "SELECT * FROM " + TABLE_CARD + " WHERE " + COLUMN_MA_CARD + "='" + mathe + "'";
        System.out.println(query);
        
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            resultSet.next();
            
            return resultSet.getRow() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
