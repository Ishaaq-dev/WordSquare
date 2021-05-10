package dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import dataManagement.DataHandler;

class PermutationsTest {
	
	DataHandler dh = new DataHandler();
	@Test
	/*
	 * Swap method swaps correct indexes with the correct letters
	 */
	void testOne() {
		String testWord = "hello";
		String result = Permutations.swap(testWord, 1, 4);
		assertEquals("holle", result);
	}
	
	@Test
	/*
	 * returns null when index specified does not exist in word
	 */
	void testTwo() {
		String testWord = "hi";
		String result = Permutations.swap(testWord, 4, 8);
		assertEquals(null, result);
	}
	
	@Test
	/*
	 * returns null when passed empty string
	 */
	void testThree() {
		String testWord = "";
		String result = Permutations.swap(testWord, 0, 5);
		assertEquals(null, result);
	}
	
	@Test
	/*
	 * returns null when passed null
	 */
	void testFour() {
		String testWord = null;
		String result = Permutations.swap(testWord, 0, 0);
		assertEquals(null, result);
	}
	
	@Test
	/*
	 * Given a string that can not be square routed to a whole number, returns null
	 */
	void testFive() {
		Permutations pms = new Permutations(null);
		List<Permutation> permutations = pms.getPermutations("abc");
		assertEquals(null, permutations);
	}
	
	@Test
	/*
	 * given a string, the method returns all possible permutations of string
	 */
	void testSix() {
		Permutations pms = new Permutations(null);
		List<Permutation> permutations = pms.getPermutations("abcd");
		assertEquals(24, permutations.size());
	}
	
	@Test
	/*
	 * Given a 4 length string, method returns 24 permutations
	 */
	void testSeven() {
		String test = "abcd";
		Permutations pms = new Permutations(null);
		List<Permutation> expectedPermutations = new ArrayList<Permutation>();
		expectedPermutations.add(new Permutation("abcd"));
		expectedPermutations.add(new Permutation("abdc"));
		expectedPermutations.add(new Permutation("acbd"));
		expectedPermutations.add(new Permutation("acdb"));
		expectedPermutations.add(new Permutation("adcb"));
		expectedPermutations.add(new Permutation("adbc"));
		expectedPermutations.add(new Permutation("bacd"));
		expectedPermutations.add(new Permutation("badc"));
		expectedPermutations.add(new Permutation("bcad"));
		expectedPermutations.add(new Permutation("bcda"));
		expectedPermutations.add(new Permutation("bdca"));
		expectedPermutations.add(new Permutation("bdac"));
		expectedPermutations.add(new Permutation("cbad"));
		expectedPermutations.add(new Permutation("cbda"));
		expectedPermutations.add(new Permutation("cabd"));
		expectedPermutations.add(new Permutation("cadb"));
		expectedPermutations.add(new Permutation("cdab"));
		expectedPermutations.add(new Permutation("cdba"));
		expectedPermutations.add(new Permutation("dbca"));
		expectedPermutations.add(new Permutation("dbac"));
		expectedPermutations.add(new Permutation("dcba"));
		expectedPermutations.add(new Permutation("dcab"));
		expectedPermutations.add(new Permutation("dacb"));
		expectedPermutations.add(new Permutation("dabc"));
		
		List<Permutation> resultedPermutations = pms.getPermutations(test);
		
		List<String> resultedPermutationString = new ArrayList<String>();
		List<String> expectedPermutationString = new ArrayList<String>();
		
		for (int i=0; i< expectedPermutations.size(); i++) {
			resultedPermutationString.add(resultedPermutations.get(i).getLetters());
			expectedPermutationString.add(expectedPermutations.get(i).getLetters());
		}
		
		assertEquals(expectedPermutationString, resultedPermutationString);
		assertEquals(24, expectedPermutationString.size());
	}
	
//	@Test
//	/*
//	 * given a 10 character string, expect the number of permutations to be 
//	 */
//	void testEight() {
//		String test = "abcdefghi";
//		List<Permutation> resultedPermutations = Permutations.getPermutations(test);
//		assertEquals(362880, resultedPermutations.size());
//	}
	
	
	/*
	 * an attempt to optimise the permutations alogorithm
	 * the next suite of tests check to see if the permutation is
	 * only stored if it contains words
	 */
	
	/*
	 * tests checkPermutation returns true if permutation contains words
	 */
	@Test
	void testNine() {
		String letters = "eeeeddoonnnsssrv";
		Trie_Shaq dictionary = dh.generateTrieForSquare(4, letters);
		Permutation permutation = new Permutation("roseovensendends");
		Permutations pms = new Permutations(dictionary);
		boolean result = pms.checkPermutationContainsWords(permutation);
		
		assertEquals(true, result);
	}
	
	/*
	 * tests checkPermutation returns false if permutation contains words
	 */
	@Test
	void testTen() {
		String letters = "eeededoonnnsssrv";
		Trie_Shaq dictionary = dh.generateTrieForSquare(4, letters);
		Permutation permutation = new Permutation(letters);
		Permutations pms = new Permutations(dictionary);
		boolean result = pms.checkPermutationContainsWords(permutation);
		
		assertEquals(false, result);
	}
	
	/*
	 * check method returns false even if one word exists in perm
	 * if there are 16 characters
	 * 4 = real word
	 * 12 = junk
	 * The system should not return/store this permutation
	 */
	@Test
	void testEleven() {
		String letters = "eeeeddoonnnsssrv"; //eddo is the real word
		Trie_Shaq dictionary = dh.generateTrieForSquare(4, letters);
		Permutation permutation = new Permutation(letters);
		Permutations pms = new Permutations(dictionary);
		boolean result = pms.checkPermutationContainsWords(permutation);
		
		assertEquals(false, result);
	}
	
	/*
	 * same as the above however 
	 * 12 = real words
	 * 4 = junk
	 * test should still return false
	 */
	@Test
	void testTwelve() {
		String letters = "roseovensendedns"; //edns is junk
		Trie_Shaq dictionary = dh.generateTrieForSquare(4, letters);
		Permutation permutation = new Permutation(letters);
		Permutations pms = new Permutations(dictionary);
		boolean result = pms.checkPermutationContainsWords(permutation);
		
		assertEquals(false, result);
	}
	
	/*
	 * given a random string of 9 characters
	 * method should return a list of usuable words to generate word squares
	 */
	@Test
	void testThirteen() {
		String letters = "nkneeeett";
		Trie_Shaq dictionary = dh.generateTrieForSquare(3, letters);
		Permutations pms = new Permutations(dictionary);
		List<Permutation> result = pms.getPermutations(letters);
		
		assertEquals(5, result.size());
	}
	
	/*
	 * Given a random String of 16 characters
	 * method should return a list of usuable words to generate word squares
	 */
//	@Test
//	void testFourteen() {
//		String letters = "eeeeddoonnnsssrv";
//		Trie_Shaq dictionary = dh.generateTrieForSquare(4, letters);
//		Permutations pms = new Permutations(dictionary);
//		List<Permutation> result = pms.getPermutations(letters, true);
//		
//		assertEquals(5, result.size());
//	}
	
	/*
	 * checkPermutationForWords()
	 */
	@Test
	void testFifteen() {
		String letters = "roseovensendends";
		Trie_Shaq dictionary = dh.generateTrieForSquare(4, letters);
		Permutation permutation = new Permutation(letters);
		Permutations pms = new Permutations(dictionary);
		
		boolean result = pms.checkPermutationForWords(permutation, 3);
		assertEquals(true, result);
	}
	
	@Test
	void testSixteen() {
		String letters = "roseovensendends";
		Trie_Shaq dictionary = dh.generateTrieForSquare(4, letters);
		Permutation permutation = new Permutation(letters);
		Permutations pms = new Permutations(dictionary);
		
		boolean result = pms.checkPermutationForWords(permutation, 7);
		assertEquals(true, result);
	}
	
	@Test
	void testSeventeen() {
		String letters = "roseovensendends";
		Trie_Shaq dictionary = dh.generateTrieForSquare(4, letters);
		Permutation permutation = new Permutation(letters);
		Permutations pms = new Permutations(dictionary);
		
		boolean result = pms.checkPermutationForWords(permutation, 11);
		assertEquals(true, result);
	}
	
	@Test
	void testEighteen() {
		String letters = "roseovensendends";
		Trie_Shaq dictionary = dh.generateTrieForSquare(4, letters);
		Permutation permutation = new Permutation(letters);
		Permutations pms = new Permutations(dictionary);
		
		boolean result = pms.checkPermutationForWords(permutation, 15);
		assertEquals(true, result);
	}
	
	@Test
	void testNineteen() {
		String letters = "roseovensendedns";
		Trie_Shaq dictionary = dh.generateTrieForSquare(4, letters);
		Permutation permutation = new Permutation(letters);
		Permutations pms = new Permutations(dictionary);
		
		boolean result = pms.checkPermutationForWords(permutation, 15);
		assertEquals(false, result);
	}
	
	@Test
	void testTwenty() {
		String letters = "roseovensndeends";
		Trie_Shaq dictionary = dh.generateTrieForSquare(4, letters);
		Permutation permutation = new Permutation(letters);
		Permutations pms = new Permutations(dictionary);
		
		boolean result = pms.checkPermutationForWords(permutation, 15);
		assertEquals(false, result);
	}
	
	@Test
	void testTwentyOne() {
		String letters = "roseovnesendends";
		Trie_Shaq dictionary = dh.generateTrieForSquare(4, letters);
		Permutation permutation = new Permutation(letters);
		Permutations pms = new Permutations(dictionary);
		
		boolean result = pms.checkPermutationForWords(permutation, 15);
		assertEquals(false, result);
	}
	
	@Test
	void testTwentyTwo() {
		String letters = "rsoeovensendends";
		Trie_Shaq dictionary = dh.generateTrieForSquare(4, letters);
		Permutation permutation = new Permutation(letters);
		Permutations pms = new Permutations(dictionary);
		
		boolean result = pms.checkPermutationForWords(permutation, 15);
		assertEquals(false, result);
	}
	
	/*
	 * test getPermutations()
	 */
	@Test
	void testTwentyThree() {
		String letters = "ntekeeetn";
		Trie_Shaq dictionary = dh.generateTrieForSquare(3, letters);
		Permutations pms = new Permutations(dictionary);
		List<Permutation> resultedList = pms.getPermutations(letters);
		
		assertEquals(6, resultedList.size());
	}
	
	@Test
	void testTwentyFour() {
		String letters = "eeeeddoonnnsssrv";
		Trie_Shaq dictionary = dh.generateTrieForSquare(4, letters);
		Permutations pms = new Permutations(dictionary);
		List<Permutation> resultedList = pms.getPermutations(letters);
		
		assertEquals(6, resultedList.size());
	}
}
