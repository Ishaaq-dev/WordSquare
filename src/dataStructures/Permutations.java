package dataStructures;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	
	public static List<Permutation> getPermutations(String letters) {
		List<Permutation> permutations = new ArrayList<Permutation>();
		double squareRoot = Math.sqrt(letters.length());
		if (squareRoot % 1 != 0) return null; 
		permute(letters, 0, letters.length() - 1, permutations);
		
		return permutations;
	}

	public static void permute(String letters, int startIndex, int endIndex, List<Permutation> permutations) {
		if (startIndex == endIndex) {
			Permutation permutation = new Permutation(letters);
			if (!permutations.contains(permutation)) permutations.add(permutation);
		} else {
			for (int i=startIndex; i<=endIndex; i++) {
				letters = swap(letters, startIndex, i);
				permute(letters, startIndex + 1, endIndex, permutations);
				letters = swap(letters, startIndex, i);
				
			}
		}
	}
	
	public static String swap(String letters, int swapIndex, int withThisIndex) {
		char[] lettersArray = null;
		char firstLetter = '\0', secondLetter = '\0';
		try {
			lettersArray = letters.toCharArray();
			firstLetter = lettersArray[swapIndex];
			secondLetter = lettersArray[withThisIndex];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Index specified does not exist in: " + letters);
			return null;
		} catch (NullPointerException e) {
			System.out.println("String input can not be null");
			return null;
		}
		
		lettersArray[swapIndex] = secondLetter;
		lettersArray[withThisIndex] = firstLetter;
		
		String newLetters = new String(lettersArray);
		
		return newLetters;
	}
}
