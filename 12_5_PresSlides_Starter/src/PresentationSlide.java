import java.util.ArrayList;

public class PresentationSlide {
	private String title;
	private ArrayList<String> bulletPoints;
	
	public PresentationSlide(){
		bulletPoints = new ArrayList<>();
	}
	
	public PresentationSlide(PresentationSlide other){
		// TODO: complete the copy constructor
		//  so it makes a deep copy
		this.bulletPoints = new ArrayList<String>();
		for(String otherPresentationSlide : other.bulletPoints) {
			bulletPoints.add(otherPresentationSlide);
		}
		this.title = new String(other.title);
	}
	
	public void addBullet(String text){
		bulletPoints.add(text);
	}
	
	public void deleteLastBullet(){
		bulletPoints.remove(bulletPoints.size() - 1);
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder(title + "\n");
		for(String pt : bulletPoints){
			sb.append("\t- ");
			sb.append(pt);
			sb.append('\n');
		}
		return sb.toString();
	}
	
}
