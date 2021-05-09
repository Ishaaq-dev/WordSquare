
import java.util.List;
import java.util.Scanner;

import dataManagement.DataHandler;
import dataStructures.Trie_Shaq;

public class Main {

	public static void main(String[] args) {
		DataHandler dh = new DataHandler();
		
		boolean check = false;
		String letters = "";
		while (!check) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter pool of letters");
			letters = scanner.nextLine().toLowerCase();
			check = validateInput(letters);
		}
		
		int sizeOfGrid = (int) Math.sqrt(letters.length());
		
		Trie_Shaq dictionary_trie = dh.generateTrieForSquare(sizeOfGrid, letters);
		List<String> dictionary = null;
	}
	
	private static boolean validateInput(String input) {
		boolean check = false;
		if (Math.sqrt(input.length()) % 1 == 0) {
			if(!input.matches("^[a-z]")) check = true;
			else System.out.println("Input must only contain letters");
		} else System.out.println("Input length can not be square rooted");
		
		return check;
	}

}
