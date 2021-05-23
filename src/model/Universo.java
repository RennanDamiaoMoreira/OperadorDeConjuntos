package model;

import java.util.ArrayList;

public class Universo {
	private ArrayList<Conjunto> conjuntos = new ArrayList<Conjunto>();
	private ArrayList<Elemento> elementos = new ArrayList<Elemento>();

	public ArrayList<Conjunto> getConjuntos() {
		return conjuntos;
	}

	public void setConjuntos(ArrayList<Conjunto> conjuntos) {
		this.conjuntos = conjuntos;
	}

	public ArrayList<Elemento> getElementos() {
		return elementos;
	}

	public void setElementos(ArrayList<Elemento> elementos) {
		this.elementos = elementos;
	}

	public Universo(ArrayList<Conjunto> conjuntos, ArrayList<Elemento> elementos) {
		super();
		this.conjuntos = conjuntos;
		this.elementos = elementos;
	}

	public Conjunto buscaConjunto(String conjunto) {
		for (Conjunto referencia : conjuntos) {
			if (referencia.getNome().equals(conjunto)) {
				return referencia;
			}
		}
		return null;
	}

	public boolean pertence(String elemento, String conjunto) throws Exception {
	
		try {
			Conjunto c = buscaConjunto(conjunto);
			if (c == null) {
				throw new Exception("nao foi possivel encontrar conjunto - error U1");
			}
			for (Elemento e: c.getElementos()) {
				if (e.getNome().equals(elemento)) {
					return true;
				}
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception();
		}
		return false;
	}

}
