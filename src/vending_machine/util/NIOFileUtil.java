package vending_machine.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import vending_machine.Product;

/**
 * Java 1.8 이상버전의 파일 유틸리티
 */
public class NIOFileUtil {

	public static File findFile(String fileName, File from) {
		if (from == null) {
			from = new File("C:\\");
		}
		
		if (from.exists() && from.isDirectory()) {
			File[] itemInDir = from.listFiles();
			
			if (itemInDir != null) {
				for (File item : itemInDir) {
					if (item.isDirectory()) {
						File result = findFile(fileName, item);
						if (result != null) {
							return result;
						}
					}
					else if ( item.getName().equals(fileName) ) {
						return item;
					}
				}
			}
		}
		else if (from.getName().equals(fileName)) {
			return from;
		}
		
		return null;
	}
	
	public static List<Product> readCSVFile(String filename) {
		
		File file = NIOFileUtil.findFile(filename, null);
		
		if (file == null) {
			return new ArrayList<>();
		}
		
		if (file.exists() && file.isFile()) {
			List<String> fileLine = new ArrayList<>();
			
			try {
				fileLine.addAll(Files.readAllLines(file.toPath(), 
												   Charset.forName("UTF-8")));
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
			List<Product> csvList = new ArrayList<>();
			Product product = null;
			String[] splittedCsvLine = null;
			
			for (String line : fileLine) {
				product = new Product();
				
				splittedCsvLine = line.trim().split(",");
				product.setName(splittedCsvLine[0].trim());
				product.setPrice( Integer.parseInt(splittedCsvLine[1].trim()) );
				product.setQuantity( Integer.parseInt(splittedCsvLine[2].trim()) );
				
				csvList.add(product);
			}
			
			return csvList;
		}
		
		return new ArrayList<>();
	}
	
}










