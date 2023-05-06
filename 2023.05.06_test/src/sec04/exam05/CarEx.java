package sec04.exam05;

public class CarEx {

	public static void main(String[] args) {
		Car  car = new Car();
		
		car.keyTurnOn();
		car.run();
		
		//마지막 speed가 50이기 때문에 50반환.
		int speed = car.getSpeed();
		
		System.out.println("현재속도 : " + speed + "km/h");

	}

}
