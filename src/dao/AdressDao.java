package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import data.FileProc;
import dto.HumanDto;

//dao -> Data Access Object
//데이터를 접근하고 편집하는 Object

public class AdressDao {
	
	Scanner sc = new Scanner(System.in);
	

	//변수 100개 생성(클래스, 객체를 생성한 게 아님/ 값 배정해줘야함)
	private HumanDto humanArr[] = new HumanDto[100];
	private int count;
	
	private FileProc fp = null;
	
	
	//기본생성자(항상생성)
	public AdressDao() {
		//변수들안에 객체를 생성
//		for (int i = 0; i < humanArr.length; i++) {
//			humanArr[i] = new HumanDto();
//		}
		
		fp = new FileProc("address");
		fileload();
		
		
		humanArr[0] = new HumanDto("홍길동", 24, "123-4567", "서울시", "절친");
		humanArr[1] = new HumanDto("성춘향", 20, "823-4567", "인천시", "여사친");
		humanArr[2] = new HumanDto("일지매", 25, "123-4967", "부천시", "무사");
		humanArr[4] = new HumanDto("홍길동", 15, "123-5555", "춘천시", "친구");
		
		
		//데이터를 새로 읽었을 때 배열의 할당되지 않은 공간을 검색
		int nextcount = 0;
		for (int i = 0; i < humanArr.length; i++) {
			if(humanArr[i] != null) {
				nextcount++;
			}
		}
		
		count = humanArr.length;
	}
	
	
	
	//추가, 삭제, 검색, 수정메소드
	public void insert() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		System.out.println("지인을 입력하세요.");
		System.out.println("이름 >>");
		String name = sc.next();
		
		System.out.println("나이 >>");
		int age = sc.nextInt();
		
		System.out.println("전화번호 >>");
		String phone = sc.next();
		
		System.out.println("주소 >>");
		String address = "";
		try {
			address = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("메모 >>");
		String memo = sc.next();
		
		
		
//		humanArr[0].setName(name);
//		humanArr[0].setAge(age);
//		humanArr[0].setPhone(phone);
//		humanArr[0].setAddress(address);
//		humanArr[0].setMemo(memo);
		
		//위에서 객체를 생성하지 않았을 경우 -> 생성자 호출해서 대입
		humanArr[0] = new HumanDto(name, age, phone, address, memo);
		count++;
	}
	
	public void delete() {
		System.out.println("삭제할 지인의 이름 >>");
		String name = sc.next();
		
//		//검색
		int index = search(name);

		if(index == -1) {
			System.out.println("해당 이름을 찾을 수 없습니다.");
		} else {
			//삭제
			humanArr[index].setName("");
			humanArr[index].setAge(0);
			humanArr[index].setPhone("");
			humanArr[index].setAddress("");
			humanArr[index].setMemo("");
			System.out.println("입력한 지인의 정보를 삭제했습니다.");
		}
		
	}
	
	public void select() { //동명이인
		//검색
		System.out.println("검색할 지인을 입력해주세요>>>");
		String name = sc.next();
		
//		찾으면서 바로 출력하는 코드
//		for (int i = 0; i < humanArr.length; i++) {
//			if(humanArr[i] != null && name.equals(humanArr[i].getName())) {
//				System.out.println(humanArr[i].toString());
//			}
//		}
		
		//찾는 사람의 수
		for (int i = 0; i < humanArr.length; i++) {
			if(humanArr[i] != null && name.equals(humanArr[i].getName())) {
				count++;
			}
		}
		if(count < 1 ) {
			System.out.println("검색한 지인은 찾을 수 없습니다.");
			return;
		}
		
		HumanDto hdto[] = new HumanDto[count];
		
		int n = 0;
		for (int i = 0; i < humanArr.length; i++) {
			if(humanArr[i] != null && name.equals(humanArr[i].getName())) {
				hdto[n] = humanArr[i];
				n++;
			}
		}
		
		//찾은 데이터의 배열
		for (int i = 0; i < hdto.length; i++) {
			System.out.println(hdto[i].toString());
		}
		
		
	}
	
	
	
	public void update() {
		//검색
		System.out.println("업데이트할 지인을 입력해주세요>>");
		String name = sc.next();
		int index = search(name);
		
		if(index == -1) {
			System.out.println("지인의 정보를 찾을 수 없습니다.");
			return;
		}
		
		//phone
		//address
		System.out.println("데이터를 찾았습니다.");
		
		System.out.println("수정된 번호>>> ");
		String Phone = sc.next();
		humanArr[index].setPhone(Phone);
		
		System.out.println("수정된 주소>>> ");
		String address = sc.next();
		humanArr[index].setAddress(address);
		
		humanArr[index].setPhone(Phone);
		humanArr[index].setAddress(address);
		
		System.out.println("정상적으로 수정되었습니다.");
	}
	
	
	//검색메소드
	public int search(String name) {
		int index = -1; // 오류방지(번호가 -1이면 못찾는것)
		for (int i = 0; i < humanArr.length; i++) {
			if(humanArr[i] != null && name.equals(humanArr[i].getName())) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	
	
	//데이터 뿌리기
	public void allDataPrint() {
		for (int i = 0; i < humanArr.length; i++) {
			if(humanArr[i] != null && humanArr[i].getName().equals("") == false) {
				System.out.println(humanArr[i].toString());
			}
		}
	}
	
	
	public void fileSave() {
		//실제 배열에 들어있는 데이터
		int count = 0;
		for (int i = 0; i < humanArr.length; i++) {
			//생성된 객체를 검사 && 삭제한 데이터를 검사
			if(humanArr[i] != null && ! humanArr[i].getName().equals("")) {
				count++;
			}
		}
		String dataArr[] = new String[count];
		// 이름 나이 번호 주소 메모
		// 홍길동+24+123-456+서울시+친구 -> 자르기좋게 해놈
		
		count = 0;
		for (int i = 0; i < humanArr.length; i++) {
			if(humanArr[i] != null && ! humanArr[i].getName().equals("")) {
				dataArr[count] = humanArr[i].toString();
				count++;
			}
		}
		fp.write(dataArr);
	}
	
	
	//메소드, 함수는 소문자로만 써도 됨
	public void fileload() {
		//datas에 fp의 read함수를 저장
		String datas[] = fp.read();
		
		//잘 출력되나 확인용
//		for(String s : datas) {
//			System.out.println(s);
		for (int i = 0; i < datas.length; i++) {
			
			String split[] = datas[i].split(":");
			//split으로 나눠졌을때 5개로 나눠짐
		//		split[0] -> 이름
		//		split[1] -> 나이
			
			humanArr[i] = new HumanDto(split[0], Integer.parseInt(split[1]), split[2], split[3],
					split[4]);
		}
		
	}
}
	
	

