
public class Main {

	public static void main(String[] args) {
		Circle big = new Circle(35.0);
		Circle little = new Circle(4.0);

		// NOTE: this call works regardless of
		//  whether big and little are Circle or Measurable references
		System.out.println(big.isBiggerThan(little));
		
		// NOTE: the following call requires big be a Circle reference
		System.out.println(big.getRadius());

	}

}
