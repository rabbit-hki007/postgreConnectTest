package postgreConnectTest;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;


public class PostgresConnectionTest {
		
		// MySQL 접속 설정
		static final String DRIVER = "org.postgresql.Driver";
		static final String URL = "jdbc:postgresql://192.168.200.111:5432/testdb"; //내꺼용
		//static final String URL = "jdbc:postgresql://192.168.200.111:5432/sample"; //준희용
		static final String USERNAME = "postgres";
		static final String PASSWORD="admin";
		
	    @Test
	    public void getMySQLConnectionTest() {
	        
	        Connection conn = null;
	        Statement stmt = null;
	        
	        try {
	            
	            System.out.println("==================== Postgres Connection START ====================");
	            
	            Class.forName(DRIVER);
	            
	            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	            stmt = conn.createStatement();
	 
	            String sql = "select id, username, password from users";
	 
	            ResultSet rs = stmt.executeQuery(sql);
	            while (rs.next()) {
	                
	                String userId = rs.getString("id");
	                String uuserName = rs.getString("username");
	                String userPassword = rs.getString("password");
	 
	                System.out.println("ID : " + userId);
	                System.out.println("USERNAME : " + uuserName);
	                System.out.println("PASSWORD: " + userPassword);
	            }
	 
	            rs.close();
	            stmt.close();
	            conn.close();
	 
	        } catch (SQLException se1) {
	            se1.printStackTrace();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        } finally {
	            try {
	                if (stmt != null) {
	                    stmt.close();
	                }
	            } catch (SQLException se) {
	                se.printStackTrace();
	            }
	            try {
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (SQLException se) {
	                se.printStackTrace();
	            }
	        }
	        
	        System.out.println("==================== Postgres Connection END ====================");
	    }

}
