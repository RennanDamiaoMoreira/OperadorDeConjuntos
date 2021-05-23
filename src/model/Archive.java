package model;

public class Archive {
	static FileWriter fw;
	static BufferedWriter bw;
	
	
	public static String[] filesDirectory() {
		File diretorio = new File(System.getProperty("user.dir") + "/export/");
		return diretorio.list();
	}
	
	
	public static String readFile(String statement) {
		String text = " ";
		try {
			File myObj = new File(System.getProperty("user.dir") + "/export/" + statement + ".txt");
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
