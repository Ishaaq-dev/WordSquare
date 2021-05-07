package dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import dataManagement.DataHandler;

public class Trie_ShaqTests {
	
	DataHandler dh = new DataHandler();
//	Trie_Shaq dictionary = dh.generateTrieForSquare(4, letters);
	/*
	 * getPerutations returns a list of permutations 
	 * that only contains real words
	 */
	@Test
	void testOne() {
		String letters = "nwes";
		Trie_Shaq trie = new Trie_Shaq();
		trie.insertWord("sewn");
		trie.insertWord("wens");
		trie.insertWord("news");
		
		List<Permutation> permutations = trie.getPermutations(letters);
		assertEquals(3, permutations.size());
	}
}
