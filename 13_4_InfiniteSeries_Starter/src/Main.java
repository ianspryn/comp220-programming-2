
public class Main {
	public static void main(String[] args){
		
		InfiniteSeries s1 = new InfiniteSeries();
		System.out.println(s1.sum(1000));
		
		InfiniteSeries s2 = new GeometricSeries(1.0, 0.9);
		//it's not the reference type that determines override?
		//The line of code above is equivalent to GeometricSeries s2 = new GeometricSeries(1.0, 0.9);
		for(int i=10; i<=100; i+=10){
			System.out.printf("First %5d terms: %12.8f\n", i, s2.sum(i));
		}
	}
}
