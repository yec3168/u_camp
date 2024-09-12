package notice.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NoticeDAO {
	
	private String driverName = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private String user = "hr";
	private String pwd = "1234";
	
	
	
	private Connection getConnection() {
		
		Connection con = null;
		
		
		
		try {
			Class.forName(this.driverName);
			con = DriverManager.getConnection(url, user, pwd);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return con;
	}
	
	
	public ResultSet select() {
		ResultSet rs = null;
		
		String sql = 
				"select * from notice " +
		        "order by num";
		
		Connection con = getConnection();
		
		if (con != null) {
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				rs = stmt.executeQuery(sql);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
		return rs;
	}
	
	
	public int insert(String title, String content) {
		int result = 0;
		Connection con = getConnection();
		
		String sql = 
				"insert into notice (num, title, content, createdt) " +
				" values ( notice_seq.nextval, ?, ?, sysdate )";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, title);
			stmt.setString(2, content);
			
			result = stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int delete(int num) {
		int result = 0;
		Connection con = getConnection();
		
		String sql = 
				"delete from notice" +
				" where num = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, num);
			
			result = stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int update(int num, String title, String content) {
		int result = 0;
		Connection con = getConnection();
		
		String sql = 
				"update notice " +
				"set title = ?, content = ? " +
				"where num in ( ? )";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, title);
			stmt.setString(2, content);
			stmt.setInt(3, num);
			
			
			result = stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	
	public ResultSet selectDetail(int num) {
			ResultSet rs = null;
			int result = 0;
			String sql = 
					"select * from notice " +
			        "where num = ? ";
			
			Connection con = getConnection();
			
			if (con != null) {
				try {
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setInt(1, num);
					
					increaseHit( num);
					rs = stmt.executeQuery();
					
					


				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		
		return rs;
	}
	
	public void increaseHit(int num) {
		int result = 0;
		Connection con = getConnection();
		String sql = 
					"update notice " +
					"set hit = hit + 1" +
					"where num in ( ? )";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, num);
			
			result = stmt.executeUpdate();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		System.out.println(result + "개의 행이 수정되었습니다.");
	}
}
