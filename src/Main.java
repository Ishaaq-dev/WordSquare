//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import dataManagement.DataHandler;
import dataStructures.Trie_Shaq;

public class Main {

	public static void main(String[] args) {
		DataHandler dh = new DataHandler();
		Trie_Shaq trie = dh.generateTrieForSquare(4, "eeeeddoonnnsssrv");
		
		System.out.println("done");
	}

}

//eeeeddoonnnsssrv
//aaaeeeefhhmoonssrrrrttttw
