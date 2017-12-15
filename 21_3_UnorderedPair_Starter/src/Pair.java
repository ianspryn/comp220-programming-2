
public class Pair<T, S> {
	//S and T are not necessarily different yypes, but they could be
	private T first;
	private S second;
	
	public Pair(T first, S second) {
		this.first = first;
		this.second = second;
	}
	public T getFirst() {
		return first;
	}
	public S getSecond() {
		return second;
	}
	
	public static void main(String[] args) {
		Pair<String, Integer> p = new Pair<>("hello", 5);
		System.out.println(p.getSecond());
	}
	
	//6a
	@Override public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(!(obj instanceof Pair)){
			return false;
		}
		
		Pair<?, ?> other = (Pair<?, ?>) obj;
		if(this.first.equals(other.first) && this.second.equals(other.second)) {
			return true;
		}
		else{
			return false;
		}
	}
	
	//6b
	@Override public int hashCode(){
		int result = 17;
		result = 37 * result + first.hashCode();
		result = 37 * result + second.hashCode();
		
		return result;
	}
}
