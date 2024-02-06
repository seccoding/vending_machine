package vending_machine.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import vending_machine.vo.Product;

public class FileUtil {

	/**
	 * 파일을 쓴다.
	 * @param parent 파일을 쓸 경로
	 * @param filename 쓸 파일의 이름
	 * @param description 파일에 쓸 내용
	 * @param append 이어서 쓸 것인지 여부
	 */
	public static void writeFile(String parent, 
								  String filename, 
								  String description, 
								  boolean append) {

		File file = new File(parent, filename);
		if ( ! file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		
		List<String> originalFileDescription = new ArrayList<>();
		if ( ! append ) {
			// 이어서 쓰지 않을 것이라면.. 영역
			int index = 2;
			while (file.exists()) {
				file = new File(file.getParent(), "java_output (" + (index++) + ").txt");
			}
		}
		else {
			// 이어서 쓸 것이라면.. 영역.
			// 기존의 파일 내용을 읽어와서 List<String>으로 반환 받는다.
			// 반환 받은 내용을 originalFileDescription 에 addAll 한다.
			originalFileDescription.addAll( FileUtil.getAllLines(file) );
		}
		// 파일을 이어서 쓸 수는 없나?
		// 파일을 이어서 쓸 수 있는 메소드는 X
		// java 1.8 도입 ==> 이어쓰기 O
		// java 1.8 미만
		//   기존의 파일 내용을 다 읽어와서 새롭게 파일을 쓴다.
		
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		
		try {
			fileWriter = new FileWriter(file, Charset.forName("UTF-8"));
			bufferedWriter = new BufferedWriter(fileWriter);
			
			if (append) {
				for (String originalFileLine : originalFileDescription) {
					bufferedWriter.write(originalFileLine);
				}
			}
			
			bufferedWriter.write(description + "\n");
			
			bufferedWriter.flush();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (bufferedWriter != null) {
				try {
					bufferedWriter.close();
				} catch (IOException e) {}
			}
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {}
			}
		}
	}
	
	public static List<String> getAllLines(File file) {
		
		if (file.exists() && file.isFile()) {
			FileReader reader = null;
			BufferedReader bufferedReader = null;
			
			try {
				reader = new FileReader(file, Charset.forName("UTF-8"));
				bufferedReader = new BufferedReader(reader);
				
				List<String> lineList = new ArrayList<>();
				
				String line = null;
				while ( (line = bufferedReader.readLine()) != null ) {
					lineList.add(line + "\n");
				}
				
				return lineList;
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
		
		// 텅빈 리스트 반환.
		return new ArrayList<>();
	}
	
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















