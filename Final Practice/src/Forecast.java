import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Forecast {
	
	 public static Map<String, Integer> countForecasts(ArrayList<String> forecasts) {
		 Map<String, Integer> wordCount = new HashMap<String, Integer>();

	        for (String forecast : forecasts) {
	            if (wordCount.containsKey(forecast))
	                wordCount.put(forecast, wordCount.get(forecast) + 1);
	            else
	                wordCount.put(forecast, 1);
	        }

	        return wordCount;
		 
	 }
	
	public static void main(String[] args) {
		ArrayList<String> forecast = new ArrayList<>();
		forecast.add("cloudy");
		forecast.add("cloudy");
		forecast.add("sunny");
		forecast.add("cloudy");
		forecast.add("partially cloudy");
		System.out.println(countForecasts(forecast));
	} 
}
