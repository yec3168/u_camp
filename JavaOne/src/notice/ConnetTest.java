package notice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnetTest {

	
	public static void main(String [] args) {
		
		
		// 1. 어떤 DBMS를 사용할 것인지?
		
		try {
			// 문자열로 이루어진 데이터를 클래스화 시켜줌.
			// oracle을 설치함.
			
			/**
			 *  1. 프로젝트 우클릭
			 *  2. properties
			 *  3. java build path 클릭
			 *  4. libaray 클릭
			 *  5. classPath에 jar external add 클릭
			 *  6. C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib  찾기
			 *  7. jar apply
			 */
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
	
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} 
		
		
		
		
		
		// 2. 오라클이 설치된 경로
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		
		
		
		
		
		// 3. 계정정보 확인
		String user = "hr";
		String password = "1234";
		
		
		
		
		
		
		// 4. 연결 시도.
		try {
			
			// driver를 연결
			// 실패시 exceiption 발생.
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println(con);
			
			
			
			
		
			
			//5. 쿼리 가져오기
//			String sql = "select * from notice";
			

//			String insert_sql = 
//					"insert into notice (num, title, content, createdt) values (notice_seq.nextval, 'title입니다.', 'content 내용', sysdate)";
			
			
			String insert_sql = 
					"insert into notice (num, title, content, createdt) values (notice_seq.nextval, ?, ?, sysdate)";
			String title = "세번째";
			String content = "세번째 내용";
			
			
			
			
			
			
			
			// 6. 실행
//			Statement stmt = con.createStatement();
//			ResultSet rs = stmt.executeQuery(sql); //select구문
//			int result = stmt.executeUpdate(insert_sql);
			
//			System.out.println(result +"개 행을 삽입하였습니다.");
			
			
			// 동적
			PreparedStatement stmt = con.prepareStatement(insert_sql);
			stmt.setString(1, title);
			stmt.setString(2, content);
		
			
			int result = stmt.executeUpdate();
			
			System.out.println(result +"개 행을 삽입하였습니다.");
			
			
			
			
			
			
			
			
			
			//7. ResultSet을 활용
//			while(rs.next()) {
//				System.out.println(rs.getString("title"));
//			}
			
			System.out.println("정상적으로 완료");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
	}
}
