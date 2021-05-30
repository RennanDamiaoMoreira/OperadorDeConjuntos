package model;

import java.util.ArrayList;

public class Conjunto {
    private String nome;
    private ArrayList<Elementos> elementos = new ArrayList<Elementos>();

    public Conjunto(String nome, ArrayList<Elementos> elementos) {
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

    public ArrayList<Elementos> getElementos() {
        return elementos;
    }

    private void setElementos(ArrayList<Elementos> elementos) {
        this.elementos = elementos;
    }

    public void addElemento(Elementos e) {
        boolean permitir = true;
        for (Elementos ref : elementos) {
            if (ref == e) {
                permitir = false;
                break;
            }
        }
        if (permitir) {
            elementos.add(e);
        }
    }

}
