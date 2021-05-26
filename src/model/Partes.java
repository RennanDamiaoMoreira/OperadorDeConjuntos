package model;

import java.util.ArrayList;

public class Partes {
    String nome;
    ArrayList<Conjunto>conjuntos;

    public Partes(Conjunto conjunto){
        ArrayList<Conjunto> conjuntos  =new ArrayList<Conjunto>();
        conjuntos.add(null);
        for (int i = 0 ; i<conjunto.getElementos().size();i++){
            ArrayList<Elemento> incrementos = new ArrayList<Elemento>();
            for (int j = i ; j<conjunto.getElementos().size();j++){
                incrementos.add(conjunto.getElementos().get(j));
                ArrayList<Elemento> elementosTem = new ArrayList<Elemento>();
                for (Elemento ref:
                     incrementos) {
                    elementosTem.add(ref);

                }
                Conjunto temp = new Conjunto(conjunto.getNome(),elementosTem);
                conjuntos.add(temp);
            }
        }
        this.nome = conjunto.getNome();
        this.conjuntos=conjuntos;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Conjunto> getConjuntos() {
        return conjuntos;
    }
}
