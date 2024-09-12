package notice.main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import notice.dao.NoticeDAO;

public class NoticeClient {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		NoticeDAO dao = new NoticeDAO();
		
		while(true) {
			System.out.print("원하는 작업을 입력해주세요 :  ");
			String data = scan.next();
			
			if(data.equals("select")) {
				ResultSet rs = dao.select();
				
				try {
					while(rs.next()) {
						System.out.println(rs);
						System.out.println("num : " + rs.getInt("num"));
						System.out.println("title : " + rs.getString("title"));
						System.out.println("hit : " + rs.getInt("hit"));
						System.out.println("createdt : " + rs.getString("createdt"));
						
						System.out.println("---------------------------------------------");
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			
			else if( data.equals("insert")) {
				System.out.print("게시글의 제목을 입력하세요. : ");
				String title = scan.next();
				
				System.out.print("게시글의 내용을 입력하세요. : ");
				String content = scan.next();
				
				System.out.println(dao.insert(title, content) +"개의 행이 삽입되었습니다.");
				System.out.println("---------------------------------------------");
			}
			else if( data.equals("update")) {
				System.out.print("수정할 게시물의 번호를 입력하세요 : ");
				int num = scan.nextInt();

				System.out.print("수정하실 게시글 제목을 입력하세요.");
				String title = scan.next();
				
				System.out.print("수정하실 게시글 내용을 입력하세요.");
				String content = scan.next();
				
				System.out.println(dao.update(num, title, content) +"개의 행이 수정되었습니다.");
				System.out.println("---------------------------------------------");
			}
			else if( data.equals("delete")) {
				System.out.print("지워야할 게시물의 번호를 입력하세요 : ");
				int num = scan.nextInt();
				
				System.out.println(dao.delete(num) +"개의 행이 삭제되었습니다.");
				System.out.println("---------------------------------------------");
			}
			else if(data.equals("exit")) {
				break;                            
			}
			else if(data.equals("detail")) {
				System.out.print("세부정보를 보고 싶은 게시글의 번호를 입력하세요.");
				int num = scan.nextInt();
				
				ResultSet detail = dao.selectDetail(num);
				try {
					if(detail.next()) {
						System.out.println(detail);
						System.out.println("num : " + detail.getInt("num"));
						System.out.println("title : " + detail.getString("title"));
						System.out.println("hit : " + detail.getInt("hit"));
						System.out.println("createdt : " + detail.getString("createdt"));
						
						System.out.println("---------------------------------------------");
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
			}
			else {
				System.out.println("잘못된 값을 입력하셨습니다.");
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				}
				System.out.println("다시 입력해 주세요.(select, update, delete, insert)");
				continue;
			}
			
		}
		
		
		
		
		
		

	}

}
