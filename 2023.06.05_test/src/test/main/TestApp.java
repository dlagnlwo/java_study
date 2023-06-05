package test.main;

import test.controller.TestController;

public class TestApp {
	public static void main(String[] args) {
		TestController controller = new TestController();
		controller.list();
	}
}
