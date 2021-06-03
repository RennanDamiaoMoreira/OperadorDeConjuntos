package view;

import model.Conjunto;
import model.Elementos;
import model.ProdutoCartesiano;
import model.Universo;

import java.util.Scanner;

public class UniversoOperador {
    static Scanner textoUsuario;

    static void menu(Universo unico, Scanner entrada) {
        textoUsuario=entrada;

        int comando = 0;
        while (comando!=12){
            System.out.println("informe a operação que deseja ser executada" +
                    "\n1-pertence" +
                    "\n2-nao pertence" +
                    "\n3-contido igual" +
                    "\nZZZZZZZZZZZZZZZZZZZZZZZ" +
                    "\n5-contido prorpriamente" +
                    "\nZZZZZZZZZZZZZZZZZZZZZZZ" +
                    "\n7-uniao" +
                    "\n8-intesecao" +
                    "\n9-produto cartesiano" +
                    "\n10-conjunto das partes" +
                    "\n11 - diferenca de conjuntos" +
                    "\n12-sair");
             comando = entrada.nextInt();
        switch (comando) {
            case 1:
                pertence(unico);
                break;
            case 2:
                naoPertence(unico);
                break;
            case 3:
                contidoIgual(unico);
                break;
            case 4:

                break;
            case 5:
                contidoPropriamente(unico);
                break;
            case 6:

                break;
            case 7:
                uniao(unico);
                break;
            case 8:
                intersecao(unico);
                break;
            case 9:
                produtoCartesiano(unico);
                break;
            case 10:
                partes(unico);
                break;
            case 11:
                diferenca(unico);
                break;
            case 12:
                return;

        }}
    }


    private static void pertence(Universo unico) {
        System.out.println("informe o elemento");
        String elementoValor = textoUsuario.next();
        System.out.println("informe o conjunto");
        String conjunto = textoUsuario.next();
        Elementos temp = new Elementos(elementoValor, Integer.parseInt(elementoValor));
        if (unico.pertence(elementoValor, conjunto)) {
            System.out.println("o elemento pertence ao conjunto ");
        } else {
            System.out.println("o elemento nao pertence ao conjunto ");
        }
    }

    private static void naoPertence(Universo unico) {
        System.out.println("informe o elemento");
        String elementoValor = textoUsuario.next();
        System.out.println("informe o conjunto");
        String conjunto = textoUsuario.next();
        Elementos temp = new Elementos(elementoValor, Integer.parseInt(elementoValor));
        if (unico.pertence(elementoValor, conjunto)) {
            System.out.println("o elemento pertence ao conjunto ");
        } else {
            System.out.println("o elemento nao pertence ao conjunto ");
        }
    }

    private static void contidoIgual(Universo unico) {
        System.out.println("informe o conjunto1");
        String conjunto1 = textoUsuario.next();
        System.out.println("informe o conjunto2");
        String conjunto2 = textoUsuario.next();

        if (unico.contidoIgual(conjunto1, conjunto2)) {
            System.out.println("Os conjuntos são contido igual");
        } else {
            System.out.println("Os conjuntos não são contido igual");
        }
    }


    private static void contidoPropriamente(Universo unico) {
        System.out.println("inforne o subconjunto");
        String sub = textoUsuario.next();
        System.out.println("informe o conjunto grandao");
        String conjunto = textoUsuario.next();
        if (unico.contidoPropriamente(sub, conjunto)) {
            if (unico.contidoIgual(sub, conjunto)) {
                System.out.println("Os conjuntos são contido igual");
            } else {
                System.out.println("o conjunto " + sub + " está contido em " + conjunto);
            }
        } else {
            System.out.println("o conjunto" + sub + " nao esta contido no" + conjunto);
        }
    }


    private static void uniao(Universo unico) {
        System.out.println("informe o conjunto1");
        String conjunto1 = textoUsuario.next();
        System.out.println("informe o conjunto2");
        String conjunto2 = textoUsuario.next();
        unico.uniao(conjunto1, conjunto2);
        Conjunto Uniao = unico.buscaConjunto(conjunto1 + "U" + conjunto2);
        System.out.println("elementos da uniao");
        for (Elementos e : Uniao.getElementos()) {
            System.out.println(e.getValor());
        }
    }

    private static void intersecao(Universo unico) {
        System.out.println("informe o conjunto1");
        String conjunto1 = textoUsuario.next();
        System.out.println("informe o conjunto2");
        String conjunto2 = textoUsuario.next();

        Conjunto inter =  unico.intercecao(conjunto1, conjunto2);
        if (inter!=null){
        System.out.println("elementos da intercecao");
        for (Elementos e : inter.getElementos()) {
            if (e!=null) {
                System.out.println(e.getValor());
            }
        }}
    }

    private static void produtoCartesiano(Universo unico) {
        System.out.println("informe o conjunto1");
        String conjunto1 = textoUsuario.next();
        System.out.println("informe o conjunto2");
        String conjunto2 = textoUsuario.next();
        ProdutoCartesiano p = new ProdutoCartesiano(unico.buscaConjunto(conjunto1), unico.buscaConjunto(conjunto2));
        p.verProd();
    }

    private static void partes(Universo unico) {
        System.out.println("informe o conjunto");
        String conjunto1 = textoUsuario.next();
        unico.gerarParte(unico.buscaConjunto(conjunto1));
        unico.getConjuntos().remove(unico.buscaConjunto(conjunto1));
        System.out.println("As partes do conjunto sao");
        for (Conjunto c : unico.getPartes().get(unico.getPartes().size() - 1).getConjuntos()) {
            if (c == null) {
                System.out.println("conjunto VAZIO");
            } else {
                String elementos = "";
                for (Elementos e : c.getElementos()) {
                    elementos = elementos + ", " + e.getValor();
                }
                System.out.println(elementos);
            }
        }
        System.out.println("deseja refazer? 1- sim 2 - nao");
        if (textoUsuario.nextInt()==1){
           Conjunto retore =  unico.getPartes().get(unico.getPartes().size() - 1).refazer();
            System.out.println(retore.getNome());
           unico.getConjuntos().add(retore);
        }

    }


    private static void diferenca(Universo unico) {
        System.out.println("informe o conjunto1");
        String conjunto1 = textoUsuario.next();
        System.out.println("informe o conjunto2");
        String conjunto2 = textoUsuario.next();
        Conjunto Diferenca = unico.diferenca(unico.buscaConjunto(conjunto1), unico.buscaConjunto(conjunto2) );
        System.out.println(Diferenca.getNome());
        for (Elementos e: Diferenca.getElementos()){
            System.out.println(e.getValor());
        }
    System.out.println("deseja salvar ? 1-- sim ");
        if (textoUsuario.nextInt()==1){
            unico.getConjuntos().add(Diferenca);
        }
    }
}
