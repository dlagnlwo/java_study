package carex;

public class Car {

	//필드
	int gas;
	
	//생성자
	Car(){
		gas = 50;
	}
	
	//메소드
	//return 값이 없는 void로 생성
	//가스 값을 저장해 줄 메소드 하나 생성
	void setGas(int gas) {
		this.gas = gas;
	}
	
	//boolean으로 가스가 있는지 없는지 체크(true of false)
	//return값이 있어야 하기 때문에 void는 없어야 됨.
	boolean isGas() {
		if(gas == 0) {
			System.out.println("가스가 없습니다. 충전해 주세요.");
			return false;
		}
		start();
		System.out.println("가스가 남아있습니다.");
		return true;
	}
	
	//실제로 가스가 동작하는 메소드 생성
	//여기선 true of false를 하지않고 if문으로 생성
	//return값이 없으므로 void 생성
	void run() {
		while(true) {
			
			if(gas > 0) {
				System.out.println("가스잔량 : " + gas);
				try {
					Thread.sleep(1000); //1초 딜레이
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				gas -= 1;
			}else {
				System.out.println("멈춥니다. " + "가스잔량 : " + gas);
				stop();
				break;
			}
		}
		return; //실행문이 끝났음을 명시
	}
	
	//시작할 때 사용할 문구 생성하는 메소드
	void start() {
		System.out.println("시동 걸었음.");
	}
	
	//차가 멈출때 시동 끄는 문구 생성하는 메소드
	void stop() {
		System.out.println("시동 꺼졌음.");
	}
	
	//실제로 메인에서 동작하는 메소드
	public void printCar() {
		Car car = new Car();
		
		//이거를 스캐너로 입력받아서 할 수 있음.
		car.setGas(5);
		
		boolean gasState = car.isGas();
		
		if(gasState) {
			System.out.println("차가 움직입니다.");
			car.run();
		}
		
		if(car.isGas()) {
			//false일 때
			System.out.println("가스 주입 x");
		}else {
			System.out.println("가스 주입해주세요");
		}
	}
	
	
	
}
