package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;


public class FileProc {

	//파일 쓰기 읽기
	private File file = null;
	
	
	
	//생성자
	public FileProc(String filename) {
		file = new File("d:\\tmp\\" + filename + ".txt");
		
		try {
			if(file.createNewFile()) {
				System.out.println("파일 생성 성공");
			} else {
				System.out.println("기존의 파일에 존재합니다.");				
			}
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	//읽기 쓰기는 같은 파일이어야함
	//AdressDao에서 리턴으로 값을 받기 위해서 String[]배열로 리턴타입 잡음
	public String[] read() {
		//리턴으로 넘겨줄 배열
		String datas[] = null;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			//1.데이터가 몇개인지 모르기 때문에 데이터의 총 갯수를 구해야함
			int count = 0;
			String str = "";//-> 한줄받고 한줄받는 빈문자열
			while((str = br.readLine()) != null) {
				count++; //데이터갯수 파악
			}
			br.close();
			
			//2.배열할당
			datas = new String[count]; //-> 데이터 갯수대로 배얼이 할당됨(생성됨)
			
			//3. 파일로부터 데이터를 배얼에 저장
			br = new BufferedReader(new FileReader(file)); //-> 아래로간 포인터를 위로 다시 올려줌 -> 초기화
			
			int w = 0;
			while((str = br.readLine()) != null) {
				datas[w] = str;
				w++;
			}
			br.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datas;
	}
	
	
	
	
	//쓰기를 먼저해야 불러와서 읽기를 할 수 있음
	//write는 파일로 출력
	public void write(String datas[]) {
		
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			
			for (int i = 0; i < datas.length; i++) {
				pw.println(datas[i]);
			}
			
			pw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("파일에 저장되었습니다.");
		
	}
	
}
