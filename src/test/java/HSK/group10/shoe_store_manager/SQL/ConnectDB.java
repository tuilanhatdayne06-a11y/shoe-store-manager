package HSK.group10.shoe_store_manager.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	private static Connection connection = null;

    public static void connect() throws SQLException {
        
    	String url = "jdbc:sqlserver://localhost;instanceName=SQLEXPRESS;databaseName=QuanLyBanGiay;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url);
            System.out.println("Kết nối CSDL ShoeStore thành công!");
        } catch (ClassNotFoundException e) {
            System.out.println("Không tìm thấy Driver JDBC!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối CSDL: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public static Connection getConnection() {
        return connection;
    }


    public static void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Đã đóng kết nối CSDL.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

  
    public static void main(String[] args) {
        try {
            ConnectDB.connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
