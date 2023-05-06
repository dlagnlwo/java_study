package Circle;

public class cylinderMain {

	public static void main(String[] args) {
		Circle c = new Circle(2.8);
		
		Cylinder cy = new Cylinder(new Circle(2.8), 5.6);
		
		double height = 5.6;

		
		System.out.println("부피 : "+(c.getArea()*height));
		System.out.println(cy.getVolume());	
	}

}
