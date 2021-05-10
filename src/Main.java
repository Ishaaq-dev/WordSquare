import java.util.Scanner;

import dataManagement.DataHandler;
import dataStructures.Permutation;
import dataStructures.Trie_Shaq;

public class Main {

	public static void main(String[] args) {
		DataHandler dh = new DataHandler();
		
		boolean check = false;
		String letters = "";
		
		Scanner scanner = new Scanner(System.in);
		while (!check) {
			System.out.println("Enter pool of letters:");
			letters = scanner.nextLine().toLowerCase();
			check = validateInput(letters);
		}
		scanner.close();
		
		int sizeOfGrid = (int) Math.sqrt(letters.length());
		
		Trie_Shaq dictionary_trie = dh.generateTrieForSquare(sizeOfGrid, letters);
		System.out.println("Words that can be used to create wordSquare:" + dictionary_trie.dictionaryToString());
		
		Permutation permutation = new Permutation(letters);
		for (int i = 0; i<permutation.getNumberOfWords(); i++) {
			
		}
	}
	
	private static boolean validateInput(String input) {
		boolean check = false;
		input = input.toLowerCase();
		input = input.replaceAll("[^a-z]", "");
		if (Math.sqrt(input.length()) % 1 == 0 && !input.isBlank()) { check = true;
		} else System.out.println(errorMessage());
		
		return check;
	}
	
	private static String errorMessage() {
		return "Input is invalid. \nInput has to have a square rootable number of characters";
	}

}
