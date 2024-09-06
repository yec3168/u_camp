package day.five;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.xml.crypto.Data;

public class IOStreamTest {

	public static void main(String[] args) {
		
		InputStream is = System.in;
		InputStreamReader ir = new InputStreamReader(is); // 생성자를 InputStream으로 설정.
		BufferedReader ib = new BufferedReader(ir);
		
		
		
	
		
//		try {
//			
//			// InputStreamReader
////			int data;
////			data =ir.read();
////			
////			while(data != -1) {
////				System.out.println((char)data);
////				data =ir.read();
////			}
//			
//			
//			
//			// BufferStream
//			String str = ib.readLine();
//			while(str != null) {
//				System.out.println(str);
//				str = ib.readLine();
//			}
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			
//		}
		
		
		
		
		
		File from =new File("src/day/five/data.txt");
		File to = new File("src/day/five/writer.txt");
//		System.out.println(from.getAbsolutePath());
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(from));
			
			// 파일 저장.
			FileWriter fileWriter =new FileWriter(to);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			
			String data = bufferedReader.readLine();
			while(data != null) {
				printWriter.println(data);
				printWriter.flush(); // 버퍼에 적어둔 data를 저장함.
				data = bufferedReader.readLine();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("완료");
	}

}
