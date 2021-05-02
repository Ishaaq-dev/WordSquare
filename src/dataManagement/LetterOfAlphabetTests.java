package dataManagement;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Map;

import org.junit.jupiter.api.Test;

class LetterOfAlphabetTests {

	char letter = "a".charAt(0);
	
	@Test
	void testAddWordMethod() {
		LetterOfAlphabet a = new LetterOfAlphabet(letter);
		boolean response = a.addWord("apple");
		assertTrue(response);
	}
	
	@Test
	void testGetHashSet() {
		LetterOfAlphabet a = new LetterOfAlphabet(letter);
		a.addWord("apple");
		HashSet<String> set = a.getHashSet(5);
		assertNotNull(set);
		assertEquals(1, set.size());
	}
	
	@Test
	void testAddingTheSameWord() {
		LetterOfAlphabet a = new LetterOfAlphabet(letter);
		boolean response = a.addWord("apple");
		boolean response2 = a.addWord("aPpLe");
		boolean response3= a.addWord("APPLE");
		HashSet<String> set = a.getHashSet(5);
		assertNotNull(set);
		assertEquals(set.size(), 1);
		assertEquals(true, response);
		assertEquals(true, response2);
		assertEquals(true, response3);
	}
	
	@Test
	void testAddWordMethodNegative() {
		LetterOfAlphabet a = new LetterOfAlphabet(letter);
		boolean reponse = a.addWord("banana");
		assertFalse(reponse);
	}
	
	@Test
	void testGetHashSetNegative() {
		LetterOfAlphabet a = new LetterOfAlphabet(letter);
		a.addWord("banana");
		HashSet<String> set = a.getHashSet(4);
		assertNull(set);
	}
	
	@Test
	void testNumberOfWordsGetter() {
		LetterOfAlphabet a = new LetterOfAlphabet(letter);
		a.addWord("apple");
		a.addWord("amazing");
		a.addWord("Any");
		a.addWord("aNy");
		a.addWord("aardvark");
		a.addWord("aaRDVark");
		int totalNumberOfWords = a.getNumberOfWords();
		assertEquals(4, totalNumberOfWords);
	}
	
	@Test
	void testMapGetter() {
		LetterOfAlphabet a = new LetterOfAlphabet(letter);
		Map<Integer, HashSet<String>> wordsMap = a.getWordsMap();
		assertEquals(wordsMap.getClass().toString(), "class java.util.HashMap");
		assertEquals(0, wordsMap.size());
	}
	
	@Test
	void toStringTest() {
		LetterOfAlphabet a = new LetterOfAlphabet(letter);
		a.addWord("apple");
		String toString = a.toString();
		assertEquals("Letter: A" + "\n" + "All words with length of characters: 5" + "\n" + "apple" + "\n" + "\n", toString);
	}
	
	@Test
	void emptyToStringTest() {
		LetterOfAlphabet a = new LetterOfAlphabet(letter);
		String toString = a.toString();
		assertEquals("Letter: A" + "\n" + "No words containing the letter: A\n", toString);
	}

}
