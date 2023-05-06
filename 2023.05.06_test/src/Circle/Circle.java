package Circle;


public class Circle {
	//필드
	
	double radius;
	double PI = 3.141592;
	
	//생성자
	
	Circle(double radius){
		this.radius = radius;
	}
	
	//현재 반지름을 사용하여 원의 면적을 구하는 메소드
	
	public double getArea() {
		return radius * radius * PI;
	}
	
}
