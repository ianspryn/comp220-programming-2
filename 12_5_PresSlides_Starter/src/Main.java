
public class Main {
	public static void main(String[] args){
		PresentationSlide s1 = new PresentationSlide();
		s1.setTitle("Slide 1");
		s1.addBullet("first bullet");
		s1.addBullet("second bullet");
		
		PresentationSlide s2 = new PresentationSlide(s1);
		s2.setTitle("Slide 2");
		s2.deleteLastBullet();
		s2.addBullet("beware of shallow copies!");
		
		System.out.println("Checking PresentationSlide copy constructor...");
		System.out.println(s1);
		System.out.println(s2);
		
		SlideDeck deck1 = new SlideDeck("paper.jpg", "brown");
		deck1.addSlide(s1);
		deck1.addSlide(new PresentationSlide(s1));
		
		SlideDeck deck2 = new SlideDeck(deck1);
		deck2.setAccentColor("blue");
		deck2.addSlide(new PresentationSlide(s2));
		
		s1.addBullet("The ORIGINAL s1!");
		
		System.out.println("Checking SlideDeck copy constructor...");
		System.out.println(deck1);
		System.out.println(deck2);
	}
}
