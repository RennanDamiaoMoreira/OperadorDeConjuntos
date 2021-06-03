package model;

import java.util.ArrayList;
import java.util.Collection;

public class Partes {
    String nome;
    ArrayList<Conjunto> conjuntos;

    public Partes(Conjunto conjunto) {
        ArrayList<Conjunto> conjuntos = new ArrayList<Conjunto>();

        conjuntos.addAll((dividirElementos(conjunto.getElementos())));

        this.nome = conjunto.getNome();
        this.conjuntos = conjuntos;
        this.conjuntos.add(null);
    }

    private ArrayList<Conjunto> dividirElementos(ArrayList<Elementos> elementos) {
        if (elementos.size() == 0) {
            return new ArrayList<Conjunto>();
        }

        Elementos ancora = elementos.get(0);

        elementos.remove(0);
        ArrayList<Conjunto> sub = dividirElementos(elementos);
        if (sub.size() == 0) {
            ArrayList<Elementos> primarioElemento = new ArrayList<Elementos>();
            primarioElemento.add(ancora);
            Conjunto primario = new Conjunto("conjunto", primarioElemento);
            sub.add(primario);
            return sub;
        }


        ArrayList<Conjunto> temp = new ArrayList<Conjunto>();
        for (Conjunto ref : sub) {
            ArrayList<Elementos> copiaElementos = new ArrayList<Elementos>();
            copiaElementos.addAll(ref.getElementos());
            copiaElementos.add(ancora);
            Conjunto copia = new Conjunto("conjunto", copiaElementos);

            temp.add(copia);
            temp.add(ref);
        }
        ArrayList<Elementos>unitarioElemento = new ArrayList<Elementos>();
        unitarioElemento.add(ancora);
        Conjunto unitario = new Conjunto("conjunto", unitarioElemento);
        temp.add(unitario);

        sub = temp;

        return sub;

    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Conjunto> getConjuntos() {
        return conjuntos;
    }
public Conjunto refazer(){
        Conjunto propriedade =this.conjuntos.get(0);
        propriedade.setNome(this.nome);

        Universo universo = new Universo(this.conjuntos,null);
        for (int i = 0 ; i <this.conjuntos.size()-1;i++){
            for (int j = i+1;j<this.conjuntos.size()-1;j++){
                if (universo.contidoPropriamente(this.getConjuntos().get(j),this.getConjuntos().get(i))){
                    if (universo.contidoPropriamente(propriedade,this.getConjuntos().get(i))){
                        propriedade=this.getConjuntos().get(i);
                    }
                }
            }
        }
        return propriedade;

}

}
