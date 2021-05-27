package test;

import fact.UniverseGenerator;
import model.Archive;
import model.ProdutoCartesiano;
import model.Universo;

import java.util.ArrayList;

public class TestedeProduto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<Archive.filesDirectory().length;i++) {
		System.out.println(Archive.filesDirectory()[i]); }
	
	System.out.println(Archive.readFile("teste"));
	UniverseGenerator.generate("teste.txt");
	
	Universo teste = UniverseGenerator.generate("teste.txt");
		ProdutoCartesiano p = new ProdutoCartesiano(teste.buscaConjunto("A"), teste.buscaConjunto("B"));
		System.out.println("A com B   "+p.getProduto());
		ProdutoCartesiano pp = new ProdutoCartesiano(teste.buscaConjunto("B"),p);
		System.out.println(pp.getNome()+"\n"+pp.getProduto());
//		for (ArrayList a : pp.getProduto()){
//			System.out.println(a.get(0).getClass().getName().contains("Array"));
//			System.out.println(a.get(1).getClass().getName().contains("Array"));
//		}
		p.verProd();
		pp.verProd();

	
	
	

	
	
	}
	

}
