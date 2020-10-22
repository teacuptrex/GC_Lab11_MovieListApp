package gcLab11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MovieListApp {
	
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Welcome to the Movie List Application!");
		
		//add movies from MoviesIO
		for(int j = 1; j <= 100; j++) {
			MovieIO.getMovie(j);
		}
		
		Map<String, String> movs = Movie.getAllMovies();
		System.out.println("There are " + movs.size() + "in this list.");
		
		do {
			int total = 0;
			int catInput = -1;
			List<String> selected = new ArrayList<>();
			
			printCategoryMenu();
			
			while(Movie.validCategory(catInput) != true) {
				System.out.println("\r\nWhat category are you interested in? ");
				catInput = scn.nextInt();
				scn.nextLine();
			}
			
			for(Map.Entry<String,String> entry : movs.entrySet()) {
				if(entry.getValue().equals(Movie.getValidCategories().get(catInput-1))) {					
					selected.add(entry.getKey());
					total++;
				}
			}
			
			Collections.sort(selected);
			
			for(String ent : selected) {
				System.out.println(ent);	
			}
			
			System.out.println("There are " + total + " movies in the " + Movie.getValidCategories().get(catInput-1) + " category.");
			
		} while (yesOrNo(scn,"Continue? (y/n)"));
		
		
		scn.close();
		
	}
	
	public static boolean yesOrNo(Scanner scn, String prompt) {
		String userInput;
		boolean yesOrNo;
		Set<String> validYes = new HashSet<>(Arrays.asList("yes","y","yeah","yep","1","ok","okay"));
		Set<String> validNo = new HashSet<>(Arrays.asList("no","nope","n","0","nah"));
		
		while(true) {
			System.out.println(prompt);
			userInput = scn.nextLine().toLowerCase();
			if(validYes.contains(userInput)) {
				yesOrNo = true;
				break;
			} else if (validNo.contains(userInput)) {
				yesOrNo = false;
				break;
			} else {
				
			}
		}
		
		return yesOrNo;
		
	}
	
	public static void printCategoryMenu() {
		List<String> cats = Movie.getValidCategories();
		
		System.out.printf("%-14s %-10s\r\n","Category","Enter Number to Select: ");
				
		for(int i = 0; i < cats.size(); i++) {
			System.out.printf("%-14s %-10s\r\n",cats.get(i),i+1);
		}	
	}
	
	


}
