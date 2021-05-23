package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class Archive {
	static FileWriter fw;
	static BufferedWriter bw;
	
	
	public static String[] filesDirectory() {
		File diretorio = new File(System.getProperty("user.dir") + "/modelo/");
		return diretorio.list();
	}
	
	
	public static String readFile(String statement) {
		String text = " ";
		try {
			File myObj = new File(System.getProperty("user.dir") + "/modelo/" + statement + ".txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();

				text = text + "\n" + data;
			}
			return text;
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return text;
	}
}
