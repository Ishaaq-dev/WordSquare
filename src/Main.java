//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import dataManagement.DataHandler;
import dataStructures.Trie;

public class Main {

	public static void main(String[] args) {
		DataHandler dh = new DataHandler();
		Map<Character, ArrayList<String>> map = dh.generateWordMapForSquare(4, "eeeeddoonnnsssrv");
		Set<Character> keys = map.keySet();
		
		for (Character uniqueLetter : map.keySet()) {
			for (String word : map.get(uniqueLetter)) {
				System.out.println(word);
			}	
		}
		
		System.out.println("done");
	}

}

//eeeeddoonnnsssrv
//aaaeeeefhhmoonssrrrrttttw
