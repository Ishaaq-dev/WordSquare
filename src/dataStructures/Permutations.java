package dataStructures;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	
	private Trie_Shaq dictionary;
	
	public Permutations(Trie_Shaq dictionary) {
		this.dictionary = dictionary;
	}
	
	public List<Permutation> getPermutations(String letters) {
		List<Permutation> permutations = new ArrayList<Permutation>();
		double squareRoot = Math.sqrt(letters.length());
		if (squareRoot % 1 != 0) return null;
		int counter =0;
		permute(letters, 0, letters.length() - 1, permutations, counter);
		
		return permutations;
	}

	public void permute(String letters, int startIndex, int endIndex, List<Permutation> permutations, int counter) {
		System.out.println(counter + ": " + letters);
		counter++;
		Permutation permutation = new Permutation(letters);
		
		boolean permute = false;
		
		
		if (startIndex == endIndex) {
			if (dictionary != null) {
				if (checkPermutationContainsWords(permutation) 
						&& !duplicatePermutationCheck(permutation, permutations)) permutations.add(permutation);
			} else {
				permutations.add(permutation);
			}
		} else {
			for (int i=startIndex; i<=endIndex; i++) {
				letters = swap(letters, startIndex, i);
				if (dictionary != null) permute = checkPermutationForWords(permutation, startIndex);
				if (permute) permute(letters, startIndex + 1, endIndex, permutations,counter);
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
	
	public boolean checkPermutationContainsWords(Permutation permutation) {
		boolean check = true;
		
		for (int i=0; i<permutation.getNumberOfWords(); i++) {
			if(!dictionary.findWord(permutation.getWord(i))) {
				check = false;
				i = permutation.getNumberOfWords();
			}
		}
		
		return check;
	}
	
	public boolean duplicatePermutationCheck(Permutation permutation, List<Permutation> permutations) {
		boolean check = false;
		
		for (int i=0; i<permutations.size(); i++) {
			if (permutation.getListOfWords().containsAll(permutations.get(i).getListOfWords())) {
				check = true;
				i = permutations.size();
			}
		}
		return check;
	}
	
	public boolean checkPermutationForWords(Permutation permutation, int startIndex) {
		boolean permute = true;
		if (dictionary != null) {
			if (permutation.checkIndex(startIndex) ) {
				List<String> list = permutation.getCheckIndexWords(startIndex);
				for (int i=0; i<list.size(); i++) {
					if(!dictionary.findWord(list.get(i))) {
						permute = false;
						i = list.size();
					}
				}
			}
		}
		return permute;
	}
}
