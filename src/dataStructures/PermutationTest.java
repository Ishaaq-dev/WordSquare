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
	
	/*
	 * method return true when index given is at the end of a word 
	 * in the list
	 */
	@Test
	void testNine() {
		String test = "quickbrowntigerjumpsindex";
		Permutation p = new Permutation(test);
		int index = 4;
		char character = test.charAt(index);
		boolean result = p.checkIndex(index);
		assertEquals(true, result);
		assertEquals('k', character);
	}
	
	/*
	 * method return true when index given is at the end of a word 
	 * in the list
	 */
	@Test
	void testTen() {
		String test = "quickbrowntigerjumpsindex";
		Permutation p = new Permutation(test);
		int index = 9;
		char character = test.charAt(index);
		boolean result = p.checkIndex(index);
		assertEquals(true, result);
		assertEquals('n', character);
	}
	
	/*
	 * method return true when index given is at the end of a word 
	 * in the list
	 */
	@Test
	void testEleven() {
		String test = "quickbrowntigerjumpsindex";
		Permutation p = new Permutation(test);
		int index = 14;
		char character = test.charAt(index);
		boolean result = p.checkIndex(index);
		assertEquals(true, result);
		assertEquals('r', character);
	}
	
	/*
	 * method return true when index given is at the end of a word 
	 * in the list
	 */
	@Test
	void testTwelve() {
		String test = "quickbrowntigerjumpsindex";
		Permutation p = new Permutation(test);
		int index = 19;
		char character = test.charAt(index);
		boolean result = p.checkIndex(index);
		assertEquals(true, result);
		assertEquals('s', character);
	}
	
	/*
	 * method return true when index given is at the end of a word 
	 * in the list
	 */
	@Test
	void testThirteen() {
		String test = "quickbrowntigerjumpsindex";
		Permutation p = new Permutation(test);
		int index = 24;
		char character = test.charAt(index);
		boolean result = p.checkIndex(index);
		assertEquals(true, result);
		assertEquals('x', character);
	}
	
	/*
	 * method returns false when index passed is not at the end of a word
	 * in the list
	 */
	@Test
	void testFourteen() {
		String test = "quickbrowntigerjumpsindex";
		Permutation p = new Permutation(test);
		int index = 2;
		char character = test.charAt(index);
		
		boolean result = p.checkIndex(index);
		assertEquals(false, result);
		assertEquals('i', character);
	}
	
	/*
	 * method returns false when index passed is not at the end of a word
	 * in the list
	 */
	@Test
	void testFifteen() {
		String test = "quickbrowntigerjumpsindex";
		Permutation p = new Permutation(test);
		int index = 0;
		char character = test.charAt(index);
		
		boolean result = p.checkIndex(index);
		assertEquals(false, result);
		assertEquals('q', character);
	}
	
	/*
	 * method returns false when index passed is not at the end of a word
	 * in the list
	 */
	@Test
	void testSixteen() {
		String test = "quickbrowntigerjumpsindex";
		Permutation p = new Permutation(test);
		int index = 100;
		
		boolean result = p.checkIndex(index);
		assertEquals(false, result);
	}
	
	/*
	 * method returns list of words from index
	 */
	@Test
	void testSeventeen() {
		String test = "quickbrowntigerjumpsindex";
		Permutation p = new Permutation(test);
		int index = 4;
		List<String> resultedList = p.getCheckIndexWords(index);
		
		assertEquals('k', test.charAt(index));
		assertEquals(1, resultedList.size());
		assertEquals("quick", resultedList.get(0));
	}
	
	@Test
	void testEighteen() {
		String test = "quickbrowntigerjumpsindex";
		Permutation p = new Permutation(test);
		int index = 9;
		List<String> resultedList = p.getCheckIndexWords(index);
		
		assertEquals('n', test.charAt(index));
		assertEquals(2, resultedList.size());
		assertEquals("quick", resultedList.get(0));
		assertEquals("brown", resultedList.get(1));
	}
	
	@Test
	void testNineteen() {
		String test = "quickbrowntigerjumpsindex";
		Permutation p = new Permutation(test);
		int index = 14;
		List<String> resultedList = p.getCheckIndexWords(index);
		
		assertEquals('r', test.charAt(index));
		assertEquals(3, resultedList.size());
		assertEquals("quick", resultedList.get(0));
		assertEquals("brown", resultedList.get(1));
		assertEquals("tiger", resultedList.get(2));
	}
	
	@Test
	void testTwenty() {
		String test = "quickbrowntigerjumpsindex";
		Permutation p = new Permutation(test);
		int index = 19;
		List<String> resultedList = p.getCheckIndexWords(index);
		
		assertEquals('s', test.charAt(index));
		assertEquals(4, resultedList.size());
		assertEquals("quick", resultedList.get(0));
		assertEquals("brown", resultedList.get(1));
		assertEquals("tiger", resultedList.get(2));
		assertEquals("jumps", resultedList.get(3));
	}
	@Test
	void testTwentyOne() {
		String test = "quickbrowntigerjumpsindex";
		Permutation p = new Permutation(test);
		int index = 24;
		List<String> resultedList = p.getCheckIndexWords(index);
		
		assertEquals('x', test.charAt(index));
		assertEquals(5, resultedList.size());
		assertEquals("quick", resultedList.get(0));
		assertEquals("brown", resultedList.get(1));
		assertEquals("tiger", resultedList.get(2));
		assertEquals("jumps", resultedList.get(3));
		assertEquals("index", resultedList.get(4));
	}
	
	@Test
	void testTwentyTwo() {
		String test = "quickbrowntigerjumpsindex";
		Permutation p = new Permutation(test);
		int index = 100;
		List<String> resultedList = p.getCheckIndexWords(index);
	
		assertEquals(null, resultedList);
	}
	
	/*
	 * method works on words larger than 5 characters
	 */
	@Test
	void testTwentyThree() {
		String test = "absoluteabsoluteabsoluteabsoluteabsoluteabsoluteabsoluteabsolute";
		int index = 63;
		Permutation p = new Permutation(test);
		List<String> resultedList = p.getCheckIndexWords(index);
		
		assertEquals('e', test.charAt(index));
		assertEquals(8, resultedList.size());
		assertEquals("absolute", resultedList.get(0));
		assertEquals("absolute", resultedList.get(1));
		assertEquals("absolute", resultedList.get(2));
		assertEquals("absolute", resultedList.get(3));
		assertEquals("absolute", resultedList.get(4));
		assertEquals("absolute", resultedList.get(5));
		assertEquals("absolute", resultedList.get(6));
		assertEquals("absolute", resultedList.get(7));
	}
}
