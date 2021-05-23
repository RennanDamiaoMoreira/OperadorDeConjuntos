package model;

import java.util.ArrayList;

public class Universo {
	private ArrayList<Conjunto> conjuntos = new ArrayList<Conjunto>();
	private ArrayList<Integer> elementos = new ArrayList<Integer>();

	public ArrayList<Conjunto> getConjuntos() {
		return conjuntos;
	}

	public void setConjuntos(ArrayList<Conjunto> conjuntos) {
		this.conjuntos = conjuntos;
	}

	public ArrayList<Integer> getElementos() {
		return elementos;
	}

	public void setElementos(ArrayList<Integer> elementos) {
		this.elementos = elementos;
	}

	public Universo(ArrayList<Conjunto> conjuntos, ArrayList<Integer> elementos) {
		super();
		this.conjuntos = conjuntos;
		this.elementos = elementos;
	}

}
