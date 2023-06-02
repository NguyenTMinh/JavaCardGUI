
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import model.SinhVien;

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
    private static final String DB_URL = "jdbc:mysql://localhost:3306/cardOs";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "";
    
    private static final String TABLE_SINHVIEN = "sinhvien";
    
    private Connection connection;
    
    public DatabaseHelper() {
        connection = getConnection(DB_URL, USER_NAME, PASSWORD);
    }
    
    public static Connection getConnection(String dbURL, String userName, 
            String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
    
    public List<SinhVien> getAllSinhVien() {
        return null;
    }
}
