package dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class PermutationTest {
	
	@Test
	/*
	 * permutation returns false with wrong input
	 */
	void testOne() {
		Permutation p = new Permutation("abhfjwueir");
		boolean result = p.isPopulated();
		assertEquals(false, result);
	}
	
	@Test
	/*
	 * permutation returns true with correct length input
	 */
	void testTwo() {
		Permutation p = new Permutation("abhnjieuthmsjdht");
		boolean result = p.isPopulated();
		assertEquals(true, result);
	}
	
	@Test 
	/*
	 * size of word is the square of length
	 */
	void testThree() {
		String test = "abhjutpolkmnjthsgdbnthdgs";
		Permutation p = new Permutation(test);
		boolean resultBoolean = p.isPopulated();
		int squareRootLength = (int) Math.sqrt(test.length());
		int result = p.getSizeOfWords();
		int numberOfWords = p.getNumberOfWords();
		
		assertEquals(true, resultBoolean);
		assertEquals(squareRootLength, result);
		assertEquals(squareRootLength, numberOfWords);
		
	}
	
	@Test 
	/*
	 * correctly populates list with 5 words
	 */
	void testFour() {
		String test = "quickbrowntigerjumpsindex";
		Permutation p = new Permutation(test);
		
		List<String> listOfWords = new ArrayList<String>();
		listOfWords.add("quick");
		listOfWords.add("brown");
		listOfWords.add("tiger");
		listOfWords.add("jumps");
		listOfWords.add("index");
		
		boolean resultBoolean = p.isPopulated();
		int squareRootLength = (int) Math.sqrt(test.length());
		int result = p.getSizeOfWords();
		int numberOfWords = p.getNumberOfWords();
		List<String> resultList = p.getListOfWords();
		
		assertEquals(true, resultBoolean);
		assertEquals(squareRootLength, result);
		assertEquals(squareRootLength, numberOfWords);
		assertEquals(listOfWords, resultList);
	}
	
	@Test
	/*
	 * correctly populates list with 8 words
	 */
	void testFive() {
		String test = "jdhnbfhtujnkmlkjhdgfthnbchsgdjutikmalkstthepqoeiwhabsndkfheyfjdi";
		Permutation p = new Permutation(test);
		boolean resultBoolean = p.isPopulated();
		int squareRootLength = (int) Math.sqrt(test.length());
		int result = p.getSizeOfWords();
		int numberOfWords = p.getNumberOfWords();
		
		assertEquals(true, resultBoolean);
		assertEquals(squareRootLength, result);
		assertEquals(squareRootLength, numberOfWords);
	}
	
	/*
	 * method returns true if word exists in list
	 */
	@Test
	void testSix() {
		String test = "quickbrowntigerjumpsindex";
		Permutation p = new Permutation(test);
		
		boolean result = p.checkWordInList("tiger");
		assertEquals(true, result);
	}
	
	/*
	 * method returns false if word does not exist in list
	 */
	@Test
	void testSeven() {
		String test = "quickbrowntigerjumpsindex";
		Permutation p = new Permutation(test);
		
		boolean result = p.checkWordInList("false");
		assertEquals(false, result);
	}
	
	/*
	 * method returns false if word does not exist in list
	 * harder
	 */
	@Test
	void testEight() {
		String test = "quickbrowntigerjumpsindex";
		Permutation p = new Permutation(test);
		
		boolean result = p.checkWordInList("ownti");
		assertEquals(false, result);
	}
}
