package model;

import java.util.ArrayList;

public class Partes {
    String nome;
    ArrayList<Conjunto> conjuntos;

    public Partes(Conjunto conjunto) {
        ArrayList<Conjunto> conjuntos = new ArrayList<Conjunto>();
        conjuntos.add(null);
        for (int i = 0; i < conjunto.getElementos().size(); i++) {
            ArrayList<Elementos> incrementos = new ArrayList<>();
            for (int j = i; j < conjunto.getElementos().size(); j++) {
                incrementos.add(conjunto.getElementos().get(j));
                ArrayList<Elementos> elementosTem = new ArrayList<>();
                for (Elementos ref :
                        incrementos) {
                    elementosTem.add(ref);

                }
                Conjunto temp = new Conjunto(conjunto.getNome(), elementosTem);
                conjuntos.add(temp);
            }
        }
        this.nome = conjunto.getNome();
        this.conjuntos = conjuntos;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Conjunto> getConjuntos() {
        return conjuntos;
    }

    public Conjunto reverso() {
        ArrayList<Elementos> elementos = new ArrayList<>();

        Conjunto reverso = new Conjunto(this.nome, elementos);
        for (Conjunto c : conjuntos){
            if (c!=null){
                for (Elementos e : c.getElementos()){
                    reverso.addElemento(e);
                }
            }
        }

        return reverso;
    }
}
