package dataManagement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import dataStructures.Permutation;

public class WordSquareTest {

	String threeLetters = "neteketen";
	String fourLetters = "ovenroseendssend";
	String fiveLetters = "threwstonearmorearthfeast";
	String sevenLetters = "odysseydegradeamoebasvaluersanalogyrenamedbravado";
	
	@Test
	void testOne() {
		List<String> wordsFromPrefix = setUpTest(threeLetters, "ne");
		assertEquals(1, wordsFromPrefix.size());
		assertEquals("net", wordsFromPrefix.get(0));
	}
	
	@Test
	void testTwo() {
		List<String> wordsFromPrefix = setUpTest(fourLetters, "o");
		assertEquals(1, wordsFromPrefix.size());
		assertEquals("oven", wordsFromPrefix.get(0));
	}
	
	@Test
	void testThree() {
		List<String> wordsFromPrefix = setUpTest(fourLetters, "se");
		assertEquals(1, wordsFromPrefix.size());
		assertEquals("send", wordsFromPrefix.get(0));
	}
	
	@Test
	void testFour() {
		List<String> wordsFromPrefix = setUpTest(fourLetters, "end");
		assertEquals(1, wordsFromPrefix.size());
		assertEquals("ends", wordsFromPrefix.get(0));
	}
	
	@Test
	void testFive() {
		WordSquare wordSquare = new WordSquare(new Permutation(threeLetters));
		List<List<String>> result = wordSquare.makeWordSquare();
		
		assertEquals(2, result.size());
	}
	
	@Test
	void testSix() {
		WordSquare wordSquare = new WordSquare(new Permutation(fourLetters));
		List<List<String>> result = wordSquare.makeWordSquare();
		
		assertEquals(1, result.size());
	}
	
	@Test
	void testSeven() {
		WordSquare wordSquare = new WordSquare(new Permutation(fiveLetters));
		List<List<String>> result = wordSquare.makeWordSquare();
		
		assertEquals(1, result.size());
	}
	
	@Test
	void testEight() {
		WordSquare wordSquare = new WordSquare(new Permutation(sevenLetters));
		List<List<String>> result = wordSquare.makeWordSquare();
		
		assertEquals(1, result.size());
	}
	
	
	
	
	private List<String> setUpTest(String letters, String prefix) {
		Permutation permutation = new Permutation(letters);
		WordSquare wordSquare = new WordSquare(permutation);
		
		List<String> wordsFromPrefix = wordSquare.getWordsFromPrefix(prefix);
		return wordsFromPrefix;		
	}
}
