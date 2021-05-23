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

	public boolean pertence(String elemento, String conjunto) {
	
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
			
		}
		return false;
	}
	public boolean contidoPropriamente (String subConjun,String conj) {
		try {
			Conjunto menor = buscaConjunto(subConjun);
			Conjunto maior = buscaConjunto(conj);
			if (menor == null || maior== null) {
				throw new Exception("nao foi possivel encontrar conjunto - error U1");
			}
			if (menor.getElementos().size()>maior.getElementos().size()) {
				return false;
			}
			boolean[]have=new boolean[menor.getElementos().size()]; 
			for (Elemento eleMenor: menor.getElementos()) {
				
				for (Elemento eleMaior:maior.getElementos()) {
				if (eleMaior.getValor()==eleMenor.getValor()) {
					have[menor.getElementos().indexOf(eleMenor)]=true;
					break;
				}
				if (maior.getElementos().indexOf(maior)==(maior.getElementos().size()-1)) {
					have[menor.getElementos().indexOf(eleMenor)]=false;
					break;
				}
				
				}
			}
			for (int i = 0 ; i<have.length;i++) {
				if (!have[i]) {
					return false;
				}
			}
			return true;
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return false;
	}
	public boolean contidoIgual(String subConjun,String conj) {
		if (!contidoPropriamente(subConjun, conj)) {
			return false;
		}
		try {
		if (buscaConjunto(subConjun).getElementos().size()==buscaConjunto(conj).getElementos().size()) {
			return true;
		}
		}catch (Exception e) {
			System.out.println("erro");
		}
		return false;
	}

}
