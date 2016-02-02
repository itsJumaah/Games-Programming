package stormtroopers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StormEngine {
	
	public static String loadFileString(String path) {
		StringBuilder builder = new StringBuilder(); //allow us to add characters to string
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path)); //reading the file
			String line;
			while((line = br.readLine()) != null) { //read next line till hit end of file
				builder.append(line + "\n"); //add a new line char after reading each line
			}
			br.close(); //close the file stream
		}
		
		catch(IOException e) {
			e.printStackTrace(); //incase of error
		}
		
		return builder.toString();
		
	}
	
	public static int parseInt(String num) {
		try {
			return Integer.parseInt(num); //convert the string into int
		}
		catch(NumberFormatException e) { //if you pass string that isnt a num throw error
			e.printStackTrace();
			return 0;				//to prevent error 0 is default
		}
		
	}
}
