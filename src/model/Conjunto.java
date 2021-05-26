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

    private void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Elemento> getElementos() {
        return elementos;
    }

    private void setElementos(ArrayList<Elemento> elementos) {
        this.elementos = elementos;
    }

    public void addElemento(Elemento e) {
        boolean permitir = true;
        for (Elemento ref : elementos) {
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
