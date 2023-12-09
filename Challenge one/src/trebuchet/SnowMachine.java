package trebuchet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SnowMachine {

	public static void main(String[] args) {
		
		File file = new File("C://Users//slind//OneDrive//Documents//Advent of code//puzzle_input.txt");
		String line;
		
		//instantiating filereader and bufferedreader
		FileReader fw;
		BufferedReader bw;
		try {
			fw = new FileReader(file);
			bw = new BufferedReader(fw);
			
			line = bw.readLine();
			int sum = 0;
			
			while (line!=null) {
				sum += getCalibrationValue(line);
				line = bw.readLine();
			}
			
			bw.close();
			fw.close();
			
			System.out.println("Total value is: " + sum);
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("error reading file");
		}
		

	}
	
	private static int getCalibrationValue(String line) {
		char firstDigit = '\0';
		char lastDigit = '\0';
		
		for (int i = 0; i < line.length(); i++) {
			if (Character.isDigit(line.charAt(i))) {
				if (firstDigit == '\0') {
					firstDigit = line.charAt(i);
				}
				lastDigit = line.charAt(i);
			}
		}
		
		if (firstDigit != '\0' && lastDigit != '\0') {
			return Integer.parseInt("" + firstDigit + lastDigit);
		}
		return 0;
		
	}


}
