package vending_machine.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import vending_machine.Product;

public class FileUtil {

	public static List<Product> readCSVFile(String parent, String filename) {

		File file = new File(parent, filename);
		
		if (file.exists() && file.isFile()) {
			FileReader reader = null;
			BufferedReader bufferedReader = null;
			
			try {
				reader = new FileReader(file, Charset.forName("UTF-8"));
				bufferedReader = new BufferedReader(reader);
				
				List<Product> csvList = new ArrayList<>();
				Product product = null;
				String[] splittedCsvLine = null;
				
				String line = null;
				while ( (line = bufferedReader.readLine()) != null ) {
					product = new Product();
					
					splittedCsvLine = line.trim().split(",");
					product.setName(splittedCsvLine[0].trim());
					product.setPrice( Integer.parseInt(splittedCsvLine[1].trim()) );
					product.setQuantity( Integer.parseInt(splittedCsvLine[2].trim()) );
					
					csvList.add(product);
				}
				
				return csvList;
			}
			catch (IOException ioe) {
				System.out.println(ioe.getMessage());
				ioe.printStackTrace();
			}
			finally {
				if (bufferedReader != null) {
					try {
						bufferedReader.close();
					} catch (IOException e) {}
				}
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException e) {}
				}
			}
		}
		
	
		
		return null;
	}
	
}















