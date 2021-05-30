package model;

import java.util.ArrayList;

public class Universo {
	private ArrayList<Conjunto> conjuntos = new ArrayList<Conjunto>();
	private ArrayList<Elementos> elementos = new ArrayList<Elementos>();
	private ArrayList<Partes> partes=new ArrayList<Partes>();

	public ArrayList<Partes> getPartes() {
		return partes;
	}

	public ArrayList<Conjunto> getConjuntos() {
		return conjuntos;
	}

	public void setConjuntos(ArrayList<Conjunto> conjuntos) {
		this.conjuntos = conjuntos;
	}

	public ArrayList<Elementos> getElementos() {
		return elementos;
	}

	public void setElementos(ArrayList<Elementos> elementos) {
		this.elementos = elementos;
	}

	public Universo(ArrayList<Conjunto> conjuntos, ArrayList<Elementos> elementos) {
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
			for (Elementos e: c.getElementos()) {
				if (e.getNome().equals(elemento)) {
					return true;
				}
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		return false;
	}
	public boolean pertence(Elementos elemento, Conjunto conjunto) {

		try {


			for (Elementos e: conjunto.getElementos()) {
				if (e.getValor()==elemento.getValor()) {
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
			for (Elementos eleMenor: menor.getElementos()) {
				
				have[menor.getElementos().indexOf(eleMenor)]=pertence(eleMenor.getNome(), conj);
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
	public boolean contidoIgual(Conjunto subConjun,Conjunto conj) {
		if (!contidoPropriamente(subConjun, conj)) {
			return false;
		}
		try {
			if (subConjun.getElementos().size()==conj.getElementos().size()) {
				return true;
			}
		}catch (Exception e) {
			System.out.println("erro");
		}
		return false;
	}
	public boolean contidoPropriamente (Conjunto subConjun,Conjunto conj) {
		try {


			if (subConjun.getElementos().size()>conj.getElementos().size()) {
				return false;
			}
			boolean[]have=new boolean[subConjun.getElementos().size()];
			for (Elementos eleMenor: subConjun.getElementos()) {

				have[subConjun.getElementos().indexOf(eleMenor)]=pertence(eleMenor, conj);
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
	public Conjunto uniao(String conjunto1,String conjunto2){

		Conjunto uniao=null;
		try{
			Conjunto conj1 = buscaConjunto(conjunto1);
			Conjunto conj2=buscaConjunto(conjunto2);
			if (conj1==null||conj2==null){
				throw new Exception("Nao foi possivel encontrar o conjunto - U1");
			}
			uniao=new Conjunto(conjunto1+"U"+conjunto2,new ArrayList<>());
			this.conjuntos.add(uniao);
			for (Elementos ref: conj1.getElementos()){
				uniao.getElementos().add(ref);
			}
			for (Elementos ref:conj2.getElementos()){
				if(!pertence(ref.getNome(),conj1.getNome())){
					uniao.getElementos().add(ref);
				}
			}
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		return uniao;
	}
	public  Conjunto intercecao(String conjunto1, String conjunto2){
		Conjunto intercecao=null;
		try{
		Conjunto conj1 = buscaConjunto(conjunto1);
		Conjunto conj2 = buscaConjunto(conjunto2);
		if (conj1==null||conj2==null){
			throw  new Exception("Nao foi possivel encontrar o conjunto - U1");
		}
		intercecao=new Conjunto(conj1.getNome()+"INTER"+conj2,new ArrayList<>());
		for (int i = 0 ; i<conj1.getElementos().size();i++){
			if (pertence(conj1.getElementos().get(i).getNome(),conj2.getNome())){
				intercecao.addElemento(conj1.getElementos().get(i));
			}
		}

		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		return intercecao;
	}
	public Partes gerarParte(Conjunto conjunto){
		Partes p = new Partes((conjunto));
		partes.add(p);
		conjuntos.remove(conjunto);
		return p;
	}


}
