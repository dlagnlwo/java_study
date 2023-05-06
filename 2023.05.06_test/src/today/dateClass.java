package today;

import java.text.SimpleDateFormat;
import java.util.*;


public class dateClass {

	// 필드 생성
	int luck;
	int count;

	// 생성자
	dateClass() {
		Random ran = new Random();
		luck = Math.abs(ran.nextInt() % 100) + 1;
		count = 10;
	}
	
	void setLuck(int luck) {
		this.luck = luck;
	}
	
	void setCount(int count) {
		this.count = count;
	}

	// 메소드
	boolean isCount() {
		if(count == 0) {
			System.out.println("횟수가 다 떨어졌습니다.");
			return false;
		}
		System.out.println("횟수가 남았습니다.");
		return true;
	}
	
	
	// 동작하는 메소드
	void run() {
		System.out.println("90%이상이면 당첨");
		
		while (true) {
			if(count > 0) {
				try {
					Thread.sleep(count);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(luck > 90) {
					nowLuck();
					System.out.println("복권사세요.");
					break;
				}else {
					nowLuck();
					System.out.println(count + "번 남았습니다.");
					count--;
				}
			}else if(count == 0){
				stop();
				break;
			}
		}
	}
	
	void nowLuck() {
		System.out.println("현재 운은 : " + luck + "%");
	}
	
	void start() {
		System.out.println("프로그램을 실행합니다.");
	}
	void stop() {
		System.out.println("프로그램을 종료합니다.");
	}
	
	

	// 실제 메인에서 실행되는 메소드
	public void printDate() {
		Date date = new Date();
		Random ran = new Random();
		dateClass d = new dateClass();
		
		
		SimpleDateFormat simple = new SimpleDateFormat("yyyy년 MM월 dd일");
		String today = simple.format(date);
		System.out.println("현재 날짜 : " + today);
		
		d.setLuck(Math.abs(ran.nextInt() % 100) + 1);
		d.setCount(10);
		
		boolean luckState = isCount();
		
		if(luckState) {
			d.run();
		}
		
	}
}
