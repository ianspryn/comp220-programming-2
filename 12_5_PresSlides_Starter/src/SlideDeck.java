import java.util.ArrayList;

public class SlideDeck {
	private String backgroundImage;
	private String accentColor;
	private ArrayList<PresentationSlide> slides;
	
	public SlideDeck(String backgroundImage, String accentColor){
		this.backgroundImage = backgroundImage;
		this.accentColor = accentColor;
		slides = new ArrayList<>();
	}
	
	// TODO: make a copy constructor that creates a deep copy
	
	public SlideDeck(SlideDeck other) {
		this.slides = new ArrayList<PresentationSlide>();
		for(PresentationSlide otherSlideDeck: other.slides) {
			slides.add(new PresentationSlide(otherSlideDeck));
		}
		this.backgroundImage = new String(other.backgroundImage);
		this.accentColor = new String(other.accentColor);
	}

	public void addSlide(PresentationSlide s){
		slides.add(s);
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Background: ");
		sb.append(backgroundImage);
		sb.append('\n');
		sb.append("Accent: ");
		sb.append(accentColor);
		sb.append('\n');
		for(PresentationSlide s : slides){
			sb.append(s.toString());
		}
		return sb.toString();
	}
	
	public String getBackgroundImage() {
		return backgroundImage;
	}
	public void setBackgroundImage(String backgroundImage) {
		this.backgroundImage = backgroundImage;
	}
	public String getAccentColor() {
		return accentColor;
	}
	public void setAccentColor(String accentColor) {
		this.accentColor = accentColor;
	}
	
}
