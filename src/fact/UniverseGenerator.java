package fact;

import model.Universo;

public class UniverseGenerator {
private static Universo universe;

public static Universo generate(String file) {
	if (file.contains(".txt")) {
		file=file.replace(".txt", "");
		
	}
	
	
	return universe;
}

}
