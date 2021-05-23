package model;

import java.util.ArrayList;

public class Conjunto {
	private char nome;
	private ArrayList<Integer> elementos = new ArrayList<Integer>();
	
	public Conjunto(char nome, ArrayList<Integer> elementos) {
		super();
		this.nome = nome;
		this.elementos = elementos;
	}
	
	public char getNome() {
		return nome;
	}
	public void setNome(char nome) {
		this.nome = nome;
	}
	public ArrayList<Integer> getElementos() {
		return elementos;
	}
	public void setElementos(ArrayList<Integer> elementos) {
		this.elementos = elementos;
	}
	
	
	
}
