package model;

public class Elemento {
String nome;
int valor;
public Elemento(String valor) {
	super();
	this.valor = Integer.parseInt(valor);
	this.nome= valor;
}
public Elemento(String nome, int valor) {
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
