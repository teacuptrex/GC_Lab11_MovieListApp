package gcLab11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Movie {

	private String title;
	private String category;
	
	private static List<String> categories = new ArrayList<>(Arrays.asList("animated","drama","horror","scifi"));
	private static Map<String,String> movies = new HashMap<>();
	
	public Movie(String title, String category) {
		this.title = title;
		this.category = category;
		movies.put(title, category);
	}
	
	public Movie() {
		//no args constructor
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public static boolean validCategory(String category) {
		return categories.contains(category.toLowerCase());	
	}
	
	@Override
	public String toString() {
		return "Movie( category = " + category + " title = " + title + ")";
	}
	
	public static Map<String,String> getAllMovies() {
		return movies;
	}
	
	public static List<String> getValidCategories() {
		return categories;
	}
	
}
