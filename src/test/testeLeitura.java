package test;

import fact.UniverseGenerator;
import model.Archive;
import model.Universo;

public class testeLeitura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<Archive.filesDirectory().length;i++) {
		System.out.println(Archive.filesDirectory()[i]); }
	
	System.out.println(Archive.readFile("teste"));
	Universo teste = UniverseGenerator.generate("teste.txt");
	System.out.println(teste.contido("A","B"));
	}
	

}
