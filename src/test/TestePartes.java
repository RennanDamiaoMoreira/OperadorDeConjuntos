package test;

import fact.UniverseGenerator;
import model.*;

import java.util.ArrayList;

public class TestePartes {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        for (int i = 0; i < Archive.filesDirectory().length; i++) {
            System.out.println(Archive.filesDirectory()[i]);
        }

        System.out.println(Archive.readFile("teste"));
        UniverseGenerator.generate("teste.txt");

        Universo teste = UniverseGenerator.generate("teste.txt");
        teste.gerarParte(teste.buscaConjunto("B"));

        Partes p = teste.getPartes().get(0);
        ArrayList<Conjunto> cPartes = p.getConjuntos();
//        System.out.println(cPartes.size());
//        for (Conjunto c : cPartes) {
//            System.out.println("--------------");
//            if (c != null) {
//                for (Elemento e : c.getElementos()) {
//
//                        System.out.println(e.getValor());
//
//                }
//            }else {
//				System.out.println("Conjunto VAZIO");
//			}
//            System.out.println("--------------");
//        }

Conjunto reverso = p.reverso();
        System.out.println("nome " +reverso.getNome());
        System.out.println("tamanho"+reverso.getElementos().size());
        for (Elemento e : reverso.getElementos()){
            System.out.println(e.getValor());
        }
    }


}
