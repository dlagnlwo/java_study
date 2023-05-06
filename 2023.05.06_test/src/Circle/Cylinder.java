package Circle;

//문제 - 3. 다음에 구현된 Circle 클래스를 참고로 다음을 만족하는 Cylinder 클래스를 작성하시오.
//
//· 원통을 나타내는 Cylinder 클래스는 Circle형의 원과 실수형의 높이를 필드로 선언
//
//· 메소드 getVolume()은 원통의 부피를 반환
//
//· Cylinder 클래스의 main() 메소드에서 반지름이 2.8, 높이가 5.6의 원통의 부피를 출력
//
//· 다음은 원을 나타내는 클래스 Circle
public class Cylinder {
	
	//필드
	Circle cir; //메소드에서 getArea()를 불러올거기 때문에 Circle cir형으로 받아옴.
	double height;
	
	//생성자
	Cylinder(Circle cir, double height){
		this.cir = cir;
		this.height = height;
	}
	
	//메소드
	
	public double getVolume() {
		return cir.getArea()*height;
	}
	
}
