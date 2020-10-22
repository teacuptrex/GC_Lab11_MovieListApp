package gcLab11;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MovieListApp {
	
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Welcome to the Movie List Application!");
		
		new Movie("Dune","scifi");
		new Movie("Serenity","scifi");
		new Movie("Escape 2120","scifi");
		new Movie("IT","horror");
		new Movie("Halloween","horror");
		new Movie("Drama Movie 1","drama");
		new Movie("Zootopia","animated");
		new Movie("The Hobbit","animated");
		new Movie("The Fox and The Hound","animated");
		new Movie("Up","animated");
		
		Map<String, String> movs = Movie.getAllMovies();
		System.out.println("There are " + movs.size() + "in this list.");
		
		String catInput = "";

		
		do {
			
			printCategoryMenu();
			
			while(Movie.validCategory(catInput) != true) {
				System.out.println("\r\nWhat category are you interested in? ");
				catInput = scn.nextLine().toLowerCase();
			}
			
			for(Map.Entry<String,String> entry : movs.entrySet()) {
				if(entry.getValue().equals(catInput)) {
					
					System.out.println(entry.getKey());
					
				}
			}
			
			catInput = "";
			
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
		
		System.out.printf("%-14s\r\n","Enter Category to Select: ");
				
		for(int i = 0; i < cats.size(); i++) {
			System.out.printf("%-14s\r\n",cats.get(i));
		}	
	}

}
