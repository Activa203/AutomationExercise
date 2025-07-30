package utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviderTestCase8 {

	
	@DataProvider(name = "SearchKeywords")
	public String[][] getSearchKeywords() throws IOException {
		String path = "E:\\Selenium Projects\\AutomationExercise\\testData\\AutomationExercise.xlsx";
		ExcelUtils xlutil = new ExcelUtils(path);

		int totalCols = xlutil.getCellCount("Sheet1", 1); // Get number of keywords
		// Assuming first row is header and second row has all keywords (row index 1)

		String[][] data = new String[totalCols - 1][1]; // -1 because first column is TestCase ID

		for (int j = 1; j < totalCols; j++) {

			// Start from column 1 (skip TestCase ID)
			data[j - 1][0] = xlutil.getCellData("Sheet1", 1, j);
		}

		return data;
	}
}
