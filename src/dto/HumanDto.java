package dto;


//DTO -> Data Transfer Object : 대체로 쓰기, 읽기용
//VO -> Value Object : 대체로 읽기전용
//주소록의 한명의 데이터를 담는 Object

public class HumanDto {

	//멤버변수
	//사람의 정보에 대한 항목(column)
	// 이름, 나이, 전화번호, 주소, 메모
	private String name;
	private int age;
	private String phone;
	private String address;
	private String memo;
	
	
	
	//기본생성자
	public HumanDto() {
		
	}


	//매개변수가 있는 생성자
	public HumanDto(String name, int age, String phone, String address, String memo) {
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.memo = memo;
	}


	
	//getter, setter
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getMemo() {
		return memo;
	}


	public void setMemo(String memo) {
		this.memo = memo;
	}


	
	//데이터 출력 잘되는지 확인용
	@Override
	public String toString() {
		return name + ":" + age + ":" + phone + ":" +  address + ":"
				+ memo;
	}
	
	
	
	
	
	
	
}
