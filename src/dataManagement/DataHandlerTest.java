package dataManagement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DataHandlerTest {

	@Test
	void dataHandlerPopulatesMap() {
		DataHandler dh = new DataHandler();
		assertNotNull(dh.getWordsMap());
		assertEquals(26, dh.getWordsMap().size());
	}
	
	@Test
	void getNumbersOfWordsTest() {
		DataHandler dh = new DataHandler();
		int totalNumberOfWords = dh.getNumberOfWords();
		assertEquals(172820, totalNumberOfWords);
	}

}
