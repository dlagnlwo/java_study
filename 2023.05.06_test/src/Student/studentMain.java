package Student;

import java.util.Scanner;

//문제 1 - 다음을 만족하는 Student 클래스를 작성하시오.
//
//· String형의 학과와 정수형의 학번을 필드로 선언
//
//· Student 클래스의 main() 메소드에서 Student 객체를 생성하여 학과와 학번 필드에 적당한 값을 입력 후 출력
//
//문제 - 2. 위에서 구현한 Student 클래스를 다음을 만족하도록 기능을 추가하여 작성하시오.
//
//· 필드를 모두 private로 하고, getter와 setter를 구현하고
//
//· Student 클래스의 main() 메소드에서 Student 객체를 생성하여 setter를 사용하여 학과와 학번 필드에 적당한 값을 입력 후 출력
public class studentMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//괄호가 있으면 메소드
		student st = new student();
		
		System.out.print("학과 입력 : ");
		String department = sc.nextLine(); //새로운 변수 생성해서 입력
		st.setDepartment(department);  //setDepartment에 this가 있으므로 setDepartment에 department저장
		
		System.out.print("id 입력 : ");
		int id = sc.nextInt();
		st.setId(id);
		
		//이제 입력 후 저장을 했으니
		//get으로 가져오기(출력)
		
		System.out.println("현재 학과 : " + st.getDepartment());
		System.out.println("현재 id : " + st.getId());

	}

}

class student {
	
	//필드
	
	//입력받을 것이기 때문에 값을 따로 주지않음.
	private String department;
	private int id;
	
	//생성자
	
//	student(){
//		department = "컴퓨터 공학";
//		id = 5;
//	}
	//set은 void 없이
	//get은 void 포함해서
	void setDepartment(String department) {
		this.department = department;
	}
	String getDepartment() {
		return this.department + "과";
	}
	void setId(int id) {
		this.id = id;
	}
	int getId() {
		return this.id; //int형은 숫자만. 뒤에 + 붙이면 안됨.
	}
	
	
	
}