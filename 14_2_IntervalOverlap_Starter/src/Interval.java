
public class Interval implements Comparable<Interval> {
	private final long start;
	private final long end;
	private final int id;
	
	Interval(int id, long start, long end){
		this.id = id;
		this.start = start;
		this.end = end;
	}
	
	public int getId(){
		return id;
	}
	public long getEnd(){
		return end;
	}
	public long getStart(){
		return start;
	}
	
	public boolean overlaps(Interval other){
		// TODO: complete this method
		/*
		if ((other.getStart() < getStart() && other.getEnd() > getEnd()) || (other.getStart() < getStart() && other.getEnd() < getEnd() && other.getEnd() > getStart()) || (other.getStart() > getStart() && other.getEnd() > getEnd() && other.getStart() < getEnd() || (other.getStart() > getStart() && other.getEnd() > getEnd()))) {
			return true;
		}
		*/
		
		/*
		if (other.getStart() > getStart()) {
			if (other.getStart() < getEnd()) {
				return true;
			}
		} else {
			if (other.getEnd() > getStart()) {
				return true;
			}
		}
		*/
		
		//Professor method
		
		//this arrives while other is present
		if (other.start <= this.start && other.start <= this.end) {
			return true;
		}
		
		//other arrives while this is present
		if (this.start <= other.start && other.start <= this.end) {
			return true;
		}
		
		return false;
	}

	@Override
	public int compareTo(Interval other) {
		if (this.start < other.start) {
			return -1;
		}
		if (this.start > other.start) {
			return 1;
		}
		//if we get down to here, then the starts are equal; check the ends..
		if (this.end < other.end) {
			return -1;
		}
		if (this.end > other.end) {
			return 1;
		}
		//if we make it to here, then the starting pointsa and the ending points are the same
		//and it's therefore a tie
		return 0;
	}

}
