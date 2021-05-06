package dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class PermutationsTest {
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
		List<Permutation> permutations = Permutations.getPermutations("abc");
		assertEquals(null, permutations);
	}
	
	@Test
	/*
	 * given a string, the method returns all possible permutations of string
	 */
	void testSix() {
		List<Permutation> permutations = Permutations.getPermutations("abcd");
		assertEquals(24, permutations.size());
	}
	
	@Test
	/*
	 * Given a 4 length string, method returns 24 permutations
	 */
	void testSeven() {
		String test = "abcd";
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
		
		List<Permutation> resultedPermutations = Permutations.getPermutations(test);
		
		List<Boolean> expectedChecks = new ArrayList<Boolean>();
		
		List<String> resultedPermutationString = new ArrayList<String>();
		List<String> expectedPermutationString = new ArrayList<String>();
		
		for (int i=0; i< expectedPermutations.size(); i++) {
			resultedPermutationString.add(resultedPermutations.get(i).getLetters());
			expectedPermutationString.add(expectedPermutations.get(i).getLetters());
		}
		
		assertEquals(expectedPermutationString, resultedPermutationString);
		assertEquals(24, expectedPermutationString.size());
	}
	
	@Test
	/*
	 * given a 10 character string, expect the number of permutations to be 
	 */
	void testEight() {
		String test = "abcdefghi";
		List<Permutation> resultedPermutations = Permutations.getPermutations(test);
		assertEquals(362880, resultedPermutations.size());
	}
}
