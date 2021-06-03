package view;

import fact.UniverseGenerator;
import model.Conjunto;
import model.Universo;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe o nome do arquivo a ser exportado");
       Universo unico =  UniverseGenerator.generate(entrada.next());
      UniversoOperador.menu(unico,entrada);
    }
}
