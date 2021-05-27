package model;

import java.util.ArrayList;

public class ProdutoCartesiano {
    String nome ;
    ArrayList<ArrayList> produto = new ArrayList<>();



    public ProdutoCartesiano (Conjunto a, Conjunto b){
        for (Elementos elementoA:a.getElementos()) {
            for(Elementos elementoB:b.getElementos()){

               ArrayList<Elementos>temp=new ArrayList<>();
               temp.add(elementoA);
               temp.add(elementoB);
                produto.add(temp);
            }

        }
        nome = a.getNome()+"X"+b.getNome();
    }
    public ProdutoCartesiano (Conjunto a, ProdutoCartesiano p){
        for (Elementos elementoA:a.getElementos()) {
            for(ArrayList<ArrayList> produtinhos:p.getProduto()){

                ArrayList temp=new ArrayList<>();
                temp.add(elementoA);
                temp.add(produtinhos);
                produto.add(temp);
            }

        }
        nome = a.getNome()+"X<"+p.getNome()+">";
    }


    public ArrayList<ArrayList> getProduto() {
        return produto;
    }

    public String getNome() {
        return nome;
    }
    public void verProd(){
        String teste="";
    for (ArrayList a :produto){
       teste=teste+"\n"+percorreProd(a);
    }
        System.out.println(teste);

    }
    public String percorreProd(ArrayList a ){
       String retorna="";
       Elementos temp;
        if (a.get(0).getClass().getName().contains("Array")){

          retorna= retorna +"["+percorreProd((ArrayList) a.get(0));
        }else{
            temp = (Elementos) a.get(0);
            retorna = retorna+"["+temp.getNome()+",";
        }
        if (a.get(1).getClass().getName().contains("java.util.ArrayList")){

            retorna=retorna +percorreProd((ArrayList) a.get(1))+"]";
        }else{
            temp = (Elementos) a.get(1);
            retorna = retorna+temp.getNome()+"]";
        }
        return retorna;
    }
}
