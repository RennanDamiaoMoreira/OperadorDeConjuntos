package model;

import java.util.ArrayList;

public class Conjunto {
	private String nome;
	private ArrayList<Elemento> elementos = new ArrayList<Elemento>();
	
	public Conjunto(String nome, ArrayList<Elemento> elementos) {
		super();
		this.nome = nome;
		this.elementos = elementos;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Elemento> getElementos() {
		return elementos;
	}
	public void setElementos(ArrayList<Elemento> elementos) {
		this.elementos = elementos;
	}
	
	
	
}
