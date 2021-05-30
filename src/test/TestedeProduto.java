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
		ProdutoCartesiano pp = new ProdutoCartesiano(teste.buscaConjunto("B"),teste.buscaConjunto("C"));
		System.out.println(pp.getNome()+"\n"+pp.getProduto());
		ProdutoCartesiano ppp = new ProdutoCartesiano(p,pp);
//
		p.verProd();
		pp.verProd();
		ppp.verProd();

	p=ppp;
	ppp = new ProdutoCartesiano(p,pp);
	ppp.verProd();
	pp=ppp;
	ppp=new ProdutoCartesiano(pp,p);
	ppp.verProd();
	
	

	
	
	}
	

}
