package dataStructures;

import java.util.HashSet;
import java.util.Map;

public class Trie {
	
	static final int SIZE = 26;
	
	static class TrieNode {
		
	    TrieNode[] Child = new TrieNode[SIZE];
	   
	    private boolean isWord;
	      
	    public TrieNode() {
	        isWord = false;
	        for (int i =0 ; i< SIZE ; i++)
	                Child[i] = null;
	    }
	    
	    public void setIsWord(boolean isWord) {
	    	this.isWord = isWord;
	    }
	    
	    public boolean getIsWord() {
	    	return isWord;
	    }
	}
    
    static void insert(TrieNode root, String Key)
    {
        int n = Key.length();
        TrieNode pChild = root;
       
        for (int i=0; i<n; i++)
        {
            int index = Key.charAt(i) - 'a';
       
            if (pChild.Child[index] == null)
                pChild.Child[index] = new TrieNode();
       
            pChild = pChild.Child[index];
        }
       
        pChild.setIsWord(true);
    }
       
    static void searchWord(TrieNode root, boolean Hash[], String str, Trie_Shaq usuableWords) {
        if (root.getIsWord() == true)
            	usuableWords.insertWord(str);
       
        for (int K =0; K < SIZE; K++)
        {
            if (Hash[K] == true && root.Child[K] != null )
            {
                char c = (char) (K + 'a');
       
                searchWord(root.Child[K], Hash, str + c, usuableWords);
            }
        }
    }
       
    static void PrintAllWords(char Arr[], TrieNode root, 
                                              int n, Trie_Shaq usuableWords)
    {
        boolean[] Hash = new boolean[SIZE];
       
        for (int i = 0 ; i < n; i++)
            Hash[Arr[i] - 'a'] = true;
       
        TrieNode pChild = root ;
       
        String str = "";
       
        for (int i = 0 ; i < SIZE ; i++)
        {
            if (Hash[i] == true && pChild.Child[i] != null )
            {
                str = str+(char)(i + 'a');
                searchWord(pChild.Child[i], Hash, str, usuableWords);
                str = "";
            }
        }
    }
    
    public static Trie_Shaq getUsuableWords(Map<Character, HashSet<String>> wordMapForSquare) {
    	char uniqueLetters[] = new char[wordMapForSquare.keySet().size()];
    	
    	int numberOfWords = 0;
		for (Character uniqueLetter : wordMapForSquare.keySet()) {
			numberOfWords += wordMapForSquare.get(uniqueLetter).size();
		}
		
		String dictionary[] = new String[numberOfWords];
    	
    	int indexForUnqiueLettersArrray = 0;
    	int indexForDictionaryArray = 0;
    	for (Character uniqueLetter : wordMapForSquare.keySet()) {
    		uniqueLetters[indexForUnqiueLettersArrray] = uniqueLetter;
    		indexForUnqiueLettersArrray++;
    		for (String word : wordMapForSquare.get(uniqueLetter)) {
    			dictionary[indexForDictionaryArray] = word;
    			indexForDictionaryArray++;
    		}
    	}
    	
    	return getUsuableWords(dictionary, uniqueLetters);
    }
    
    public static Trie_Shaq getUsuableWords(String[] dictionary, char uniqueLetters[]) {
    	Trie_Shaq usuableWords = new Trie_Shaq();
    	
    	TrieNode node = new TrieNode();
        
        int n = dictionary.length;
        for (int i=0; i<n; i++)
            insert(node, dictionary[i]);
       
        int N = uniqueLetters.length;
       
        PrintAllWords(uniqueLetters, node, N, usuableWords);
    	
    	return usuableWords;
    }
}
