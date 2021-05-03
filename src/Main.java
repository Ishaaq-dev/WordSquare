//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;

import dataManagement.DataHandler;
import dataManagement.LetterOfAlphabet;

public class Main {

	public static void main(String[] args) {
		DataHandler dh = new DataHandler();
		Map<Character, HashSet<String>> map = dh.generateWordMapForSquare(4, "eeeeddoonnnsssrv");
		
		for (Character characterKey : map.keySet()) {
			System.out.println(map.get(characterKey));
		}
		
		System.out.println("done");
	}

}
