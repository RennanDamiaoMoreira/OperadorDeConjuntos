package model;

public class Elementos {
String nome;
int valor;
public Elementos(String valor) {
	super();
	this.valor = Integer.parseInt(valor);
	this.nome= valor;
}
public Elementos(String nome, int valor) {
	super();
	this.nome = nome;
	this.valor = valor;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public int getValor() {
	return valor;
}
public void setValor(int valor) {
	this.valor = valor;
}

}
