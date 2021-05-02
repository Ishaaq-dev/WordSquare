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
		assertEquals(set.size(), 1);
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
		assertEquals(response, true);
		assertEquals(response2, true);
		assertEquals(response3, true);
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
	void testGetter() {
		LetterOfAlphabet a = new LetterOfAlphabet(letter);
		Map<Integer, HashSet<String>> wordsMap = a.getWordsMap();
		assertEquals(wordsMap.getClass().toString(), "class java.util.HashMap");
		assertEquals(wordsMap.size(), 0);
	}
	
	@Test
	void toStringTest() {
		LetterOfAlphabet a = new LetterOfAlphabet(letter);
		a.addWord("apple");
		String toString = a.toString();
		assertEquals(toString, "Letter: A" + "\n" + "All words with length of characters: 5" + "\n" + "apple" + "\n");
	}
	
	@Test
	void emptyToStringTest() {
		LetterOfAlphabet a = new LetterOfAlphabet(letter);
		String toString = a.toString();
		assertEquals(toString, "Letter: A" + "\n" + "No words containing the letter: A\n");
	}

}
