package model;

import java.util.ArrayList;
import java.util.Collection;

public class Partes {
	String nome;
	ArrayList<Conjunto> conjuntos;

	public Partes(Conjunto conjunto) {
		ArrayList<Conjunto> conjuntos = new ArrayList<Conjunto>();
		
		conjuntos.addAll((dividirElementos(conjunto.getElementos())));
		corrigeConjuntos(conjuntos);
		this.nome = conjunto.getNome();
		this.conjuntos = corrigeConjuntos(conjuntos);
		this.conjuntos.add(null);
	}

	private ArrayList<Conjunto> dividirElementos(ArrayList<Elementos> elementos) {
		if (elementos.size() == 0) {
			return new ArrayList<Conjunto>();
		}

		Elementos ancora = elementos.get(0);

		ArrayList<Elementos> retornaAncora = new ArrayList<Elementos>();
		ArrayList<Conjunto> sub = new ArrayList<Conjunto>();
		ArrayList<Conjunto> temp = new ArrayList<Conjunto>();
		retornaAncora.addAll(elementos);
		retornaAncora.remove(0);
		sub.addAll(dividirElementos(retornaAncora));

		if (sub.size() == 0) {
			Conjunto primario = new Conjunto("conjunto ", new ArrayList<Elementos>());
			primario.addElemento(ancora);
			sub.add(primario);

			return sub;
		}

		for (Conjunto ref : sub) {
			if (ref != null) {
				Conjunto temporario = new Conjunto("conjunto ", new ArrayList<Elementos>());
				temporario.getElementos().addAll(ref.getElementos());
				temporario.addElemento(ancora);
				temp.add(temporario);
				temporario = new Conjunto("conjunto", new ArrayList<Elementos>());
				temporario.addElemento(ancora);
				temp.add(temporario);
				temp.addAll(sub);
			}

			
		}

		return temp;

	}

	public String getNome() {
		return nome;
	}

	public ArrayList<Conjunto> getConjuntos() {
		return conjuntos;
	}

	private ArrayList<Conjunto> corrigeConjuntos(ArrayList<Conjunto> conjuntos) {
		ArrayList<Conjunto> retorna = new ArrayList<Conjunto>();

		for (int i = 0; i < conjuntos.size(); i++) {
			boolean add = true;
			if(conjuntos.get(i)!=null) {
			for (int j = i + 1; j < conjuntos.size(); j++) {
				ArrayList<Conjunto> temp = new ArrayList<Conjunto>();
				temp.add(conjuntos.get(i));
				temp.add(conjuntos.get(j));
				Universo teste = new Universo(temp, null);
				
				
				if (teste.contidoIgual(conjuntos.get(i), conjuntos.get(j))) {
					
					add = false;
					break;
				}}
			

				if (add) {
					
					retorna.add(conjuntos.get(i));
				}}
			
		}
		return retorna;
	}

}
