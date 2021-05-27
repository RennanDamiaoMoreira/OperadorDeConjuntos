package fact;

import java.util.ArrayList;

import model.Archive;
import model.Universo;
import model.Conjunto;
import model.Elementos;

public class UniverseGenerator {
	private static Universo universe;

public static Universo generate(String file) {
	if (file.contains(".txt")) {
		file=file.replace(".txt", "");
		
	}
	String base=Archive.readFile(file);
	ArrayList<Conjunto> conjuntos =new ArrayList<Conjunto>();
	ArrayList<Elementos> elementosTemp;
	ArrayList<Elementos> elementosUniverso=new ArrayList<Elementos>();
	String[] linhas=base.split("\n");
	
	for (String linha : linhas) {
		if (linha.contains("{")) {
			int posiChave=linha.indexOf("{")+1;
			int posiFecha=linha.indexOf("}");
			elementosTemp = new ArrayList<Elementos>();
			for(String elemento : linha.substring(posiChave, posiFecha).split(",")) {
				if (elemento.contains(" ")) {
					elemento=elemento.replaceAll(" ", "");
					
				}
				elementosTemp.add(new Elementos(elemento));
			}
			Conjunto conjuTemp = new  Conjunto(linha.substring(0, linha.indexOf("=")).replaceAll(" ", ""), elementosTemp);
			conjuntos.add(conjuTemp);
		}else {
			if (linha.contains("=")) {
				
				Elementos temp  = new Elementos((linha.substring(0,linha.indexOf("=")).replaceAll(" ", "")), Integer.parseInt(linha.substring(linha.indexOf("=")+1, linha.length()).replace(" ","")));
				elementosUniverso.add(temp);
			}
		}
	}
	universe=new Universo(conjuntos, elementosUniverso);
	return universe;
}

}
